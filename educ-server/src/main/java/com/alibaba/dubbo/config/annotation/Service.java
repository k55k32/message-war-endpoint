/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Service
 * 
 * @author william.liangf
 * @export
 */
/**
 * Overwrite
 * 使用 @com.alibaba.dubbo.config.annotation.Service 发布dubbo服务的时候,
 * 当服务类没有加入@Transactional的时候没有问题.	但是当加入事务后【@Transactional】, dubbo的 AnnotationBean 扫描 类执行下面的代码的时候就获取不到对应的注解,
 * 也就发布不了服务。究其原因，是因为Dubbo提供的注解没有@Inherited元注解。
 * 
 * @author Diamond
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Service {

    Class<?> interfaceClass() default void.class;

    String interfaceName() default "";

    String version() default "";

    String group() default "";

    String path() default "";

    boolean export() default false;

    String token() default "";

    boolean deprecated() default false;

    boolean dynamic() default false;

    String accesslog() default "";

    int executes() default 0;

    boolean register() default false;

    int weight() default 0;

    String document() default "";

    int delay() default 0;

    String local() default "";

    String stub() default "";

    String cluster() default "";

    String proxy() default "";

    int connections() default 0;

    int callbacks() default 0;

    String onconnect() default "";

    String ondisconnect() default "";

    String owner() default "";

    String layer() default "";

    int retries() default 0;

    String loadbalance() default "";

    boolean async() default false;

    int actives() default 0;

    boolean sent() default false;

    String mock() default "";

    String validation() default "";

    int timeout() default 0;

    String cache() default "";

    String[] filter() default {};

    String[] listener() default {};

    String[] parameters() default {};

    String application() default "";

    String module() default "";

    String provider() default "";

    String[] protocol() default {};

    String monitor() default "";

    String[] registry() default {};

}
