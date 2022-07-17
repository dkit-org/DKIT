package org.dkit.engineclient.container;

import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.model.Frame;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;

@Component
@Scope(value = "prototype")
public class ContainerLogCallback implements ResultCallback<Frame> {
    @Override
    public void onStart(Closeable closeable) {

    }

    @Override
    public void onNext(Frame object) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void close() throws IOException {

    }
}
