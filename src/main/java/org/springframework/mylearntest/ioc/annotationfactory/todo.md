1. classpath-scanning的时候，在对标注了@Component或者其他注解的类进行处理的同时，也稍带检查一下当前类是否也标注了@FactoryMethod。如果是，则进一步将工厂方法相关信息添加到相应的BeanDefinition。
2. 向容器中新添加一个BeanFactoryPostProcessor实现类，由这个BeanFactoryPostProcessor来统一做@FactoryMethod 的 相 关 处 理 。 不 过 ， 这 需 要 org.springframework.beans.factory.config.BeanFactoryPostProcessor接口开放更多一些的接口。在
Spring 3.0 M2的Javadoc中可以发现这样的迹象，所以这条路应该也可以走通。