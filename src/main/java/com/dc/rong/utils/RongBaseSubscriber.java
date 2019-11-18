package com.dc.rong.utils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

@Slf4j
public class RongBaseSubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnNext(T value) {
       request(1);
    }

    @Override
    protected void hookFinally(SignalType type) {
        log.info("reactor thread is execute end");
        super.hookFinally(type);
    }

}
