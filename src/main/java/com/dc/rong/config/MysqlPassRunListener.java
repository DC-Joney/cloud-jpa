package com.dc.rong.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

@Slf4j
@NoArgsConstructor
@Order(0)
public class MysqlPassRunListener implements SpringApplicationRunListener, EnvironmentPostProcessor {

    private SpringApplication application;

    private String[] args;

    public MysqlPassRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
    }


    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        environment.getPropertySources()
                .addLast(new MysqlPassPropertySource());
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Binder binder = Binder.get(environment);
//        BindResult<String> bindResult = binder.bind("mysql_pass", Bindable.of(String.class).withSuppliedValue(() -> "kanglu5211314"));
    }

    private static class MysqlPassPropertySource extends PropertySource<ConnectionPass>{
        private static final String MYSQL_PASS_PROPERTY_NAME = "mysql_pass";
        private static ConnectionPass connectionPass = ConnectionPass.of("kanglu5211314");
        private MysqlPassPropertySource() {
            super(MYSQL_PASS_PROPERTY_NAME, connectionPass);
        }

        @Override
        public Object getProperty(String name) {
            if(name.equals(MYSQL_PASS_PROPERTY_NAME)){
                return connectionPass.password;
            }
            return null;
        }
    }

    @Getter
    @RequiredArgsConstructor(staticName = "of")
    private static class ConnectionPass{
        @NonNull
        private String password;
    }

}
