package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.rsocket.RSocketAppContext;
import com.alibaba.rsocket.cloudevents.CloudEventImpl;
import com.alibaba.rsocket.cloudevents.RSocketCloudEventBuilder;
import com.alibaba.rsocket.upstream.UpstreamClusterChangedEvent;
import io.rsocket.metadata.WellKnownMimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.extra.processor.TopicProcessor;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * Ops Controller
 *
 * @author linux_china
 */
@RestController
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class OpsController {
    @Autowired
    private TopicProcessor<CloudEventImpl<?>> eventProcessor;

    @PostMapping("/upstream/update")
    public String updateUpstream(@RequestBody String uris) throws Exception {
        UpstreamClusterChangedEvent upstreamClusterChangedEvent = new UpstreamClusterChangedEvent();
        upstreamClusterChangedEvent.setGroup("");
        upstreamClusterChangedEvent.setInterfaceName("*");
        upstreamClusterChangedEvent.setVersion("");
        upstreamClusterChangedEvent.setUris(Arrays.asList(uris.split(",")));

        // passing in the given attributes
        CloudEventImpl<UpstreamClusterChangedEvent> cloudEvent = RSocketCloudEventBuilder.<UpstreamClusterChangedEvent>builder()
                .withType("com.alibaba.rsocket.upstream.UpstreamClusterChangedEvent")
                .withId(UUID.randomUUID().toString())
                .withTime(OffsetDateTime.now())
                .withDataContentType(WellKnownMimeType.APPLICATION_JSON.getString())
                .withSource(new URI("app://" + RSocketAppContext.ID))
                .withData(upstreamClusterChangedEvent)
                .build();
        eventProcessor.onNext(cloudEvent);
        return "success";
    }
}
