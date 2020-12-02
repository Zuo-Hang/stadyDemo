`@RestController`。这被称为*构造型*注释。它为阅读代码的人和Spring提供了提示，提示该类起特定的作用。

`@RequestMapping`注释提供“路由”的信息。

`@EnableAutoConfiguration`。这个注释告诉Spring Boot根据添加的jar依赖关系“猜测”您如何配置Spring。

maven打包后可生成XXX.jar,如果您想窥视内部，可以使用`jar tvf`，如下所示：

```
$ jar tvf target / myproject-0.0.1-SNAPSHOT.jar
```

Cassandra分布式数据库?

Couchbase面向文档的数据库？

MongoDB面向文档的数据库？

Neo4j图形数据库？

@Configuration

@Import

@ComponentSca

@EnableAutoConfiguration

@SpringBootApplication

单个`@SpringBootApplication`注释可用于启用这三个功能，即：

- `@EnableAutoConfiguration`：启用[Spring Boot的自动配置机制]
- `@ComponentScan`：启用`@Component`对应用程序所在的软件包的扫描
- `@Configuration`：允许在上下文中注册额外的bean或导入其他配置类

只能添加一个`@SpringBootApplication`或`@EnableAutoConfiguration`注释。通常建议仅将一个或另一个添加到您的主要`@Configuration`班级。

如果发现正在应用不需要的特定自动配置类，则可以使用exclude属性`@SpringBootApplication`来禁用它们

```
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
```

可以添加`@ComponentScan`而无需任何参数。您的所有应用程序组件（的`@Component`，`@Service`，`@Repository`，`@Controller`等）自动注册为spring bean

如果bean具有一个构造函数，则可以省略`@Autowired`

```
@Service
public class DatabaseAccountService implements AccountService {

    private final RiskAssessor riskAssessor;

    @Autowired
    public DatabaseAccountService(RiskAssessor riskAssessor) {
        this.riskAssessor = riskAssessor;
    }

    // ...

}
```

```
@Service
public class DatabaseAccountService implements AccountService {

    private final RiskAssessor riskAssessor;

    public DatabaseAccountService(RiskAssessor riskAssessor) {
        this.riskAssessor = riskAssessor;
    }

    // ...

}
```

`spring-boot-devtools`模块:

`spring-boot-devtools`只要类路径上的文件发生更改，使用的应用程序就会自动重新启动。在IDE中工作时，这可能是一个有用的功能，因为它为代码更改提供了非常快速的反馈循环。默认情况下，将监视类路径上指向目录的任何条目的更改。请注意，某些资源（例如静态资产和视图模板）[不需要重新启动应用程序]。

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

运行完全打包的应用程序时，将自动禁用开发人员工具。如果您的应用程序是`java -jar`从某个特殊的类加载器启动的，或者从特殊的类加载器启动的，则将其视为“生产应用程序”。如果那对您不适用（即，如果您从容器中运行应用程序），请考虑排除devtools或设置`-Dspring.devtools.restart.enabled=false`系统属性。

重新启动与重新加载

Spring Boot提供的重启技术通过使用两个类加载器来工作。不变的类（例如，来自第三方jar的类）将被加载到*基本*类加载器中。您正在积极开发的类将加载到*重新启动*类加载器中。重新启动应用程序后，将丢弃*重新启动*类加载器，并创建一个新的类加载器。这种方法意味着应用程序的重启通常比“冷启动”要快得多，因为*基本*类加载器已经可用并已填充。

如果发现重新启动不够快,则ZeroTurnaround 重新加载技术，例如[JRebel](https://jrebel.com/software/jrebel/)

`SpringApplication`允许延迟地初始化应用程序。启用延迟初始化后，将根据需要创建bean，而不是在应用程序启动期间创建bean。因此，启用延迟初始化可以减少应用程序启动所花费的时间。

```
spring.main.lazy-initialization=true
```

如果要在对应用程序其余部分使用延迟初始化时禁用某些bean的延迟初始化，则可以使用`@Lazy(false)`批注将它们的延迟属性显式设置为false 。

spring：

装配bean的方式：xml、Java config、自动装配。

@@Resource和@Autowired的区别？



beanFactory：重点 了解beanFactory的特性或者beanFactory的各种api

其中存在一个beanDefintionMap，存储beanDefintion的集合，beanDefintion具有bean类的类名、scope、属性**、**构造函数参数列表**、**依赖的bean**、**是否是单例类**、**是否是懒加载等，其实就是将Bean的定义信息存储到这个BeanDefinition相应的属性中，后面对Bean的操作就直接对BeanDefinition进行，例如拿到这个BeanDefinition后，可以根据里面的类名、构造函数、构造函数参数，使用反射进行对象创建。

整个容器初始化过程就是spring各种后置处理器调用过程；而各种后置处理器当中大体分为两种；一种关于实例化的后置处理器一种是关于初始化的后置处理器

BeanFactoryPostProcessor bean工厂的后置处理器 （对于实例化后的BeanFactory进行进一步的配置->初始化）   扩展点  程序员一般提供BeanFactoryPostProcessor是为了对beanFactory做修改或者叫做干预他的初始化；

ConfigurableListableBeanFactory



spring自定义标签（注解）

自定义标签可以简单分为四个步骤，分别是

- 编写.schemas文件，通知spring容器我们定义的xsd文件在哪里；
- 编写.xsd文件，定义配置时可以使用的属性限制或者说支持的那些属性配置；
- 编写.handlers 文件，扩展NamespaceHandler命名空间注册器和定义及解析器；
- 在xml文件中使用自定义标签



BeanFactory:BeanFactory是接口，提供了OC容器最基本的形式，给具体的IOC容器的实现提供了规范

FactoryBean:FactoryBean也是接口，为IOC容器中Bean的实现提供了更加灵活的方式，FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单工厂模式和装饰模式

BeanFactory是个Factory，也就是IOC容器或对象工厂，FactoryBean是个Bean。

一般情况下，Spring通过反射机制利用<bean>的class属性指定实现类实例化Bean，在某些情况下，实例化Bean过程比较复杂，如果按照传统的方式，则需要在<bean>中提供大量的配置信息。配置方式的灵活性是受限的，这时采用编码的方式可能会得到一个简单的方案。Spring为此提供了一个org.springframework.bean.factory.FactoryBean的工厂类接口，用户可以通过实现该接口定制实例化Bean的逻辑。FactoryBean接口对于Spring框架来说占用重要的地位，Spring自身就提供了70多个FactoryBean的实现。它们隐藏了实例化一些复杂Bean的细节，给上层应用带来了便利。从Spring3.0开始，FactoryBean开始支持泛型，即接口声明改为FactoryBean<T>的形式

以Bean结尾，表示它是一个Bean，不同于普通Bean的是：它是实现了FactoryBean<T>接口的Bean，根据该Bean的ID从BeanFactory中获取的实际上是FactoryBean的getObject()返回的对象，而不是FactoryBean本身，如果要获取FactoryBean对象，请在id前面加一个&符号来获取。

Ioc： Ioc容器的初始化  Bean依赖注入的实现

Ioc容器初始化：

入口为refresh（）方法，

1.Rescue定位

2.BeanDefinition载入：把定义的BeanDefinition在Ioc容器中转换成一个spring内部表示的数据结构的过程。载入分为两个部分：调用Xml的解析器得到document对象、按照spring的Bean的规则进行解析——

3.向Ioc容器注册

spring将这三个过程分开使用不同的模块来完成，ResourceLoader、BeanDefinitionReader、BeanDefinitionRegistry等模块。

BeanDefinition

FileSystemXmlApplicationContext

```
AbstractXmlApplicationContext
```

FileSystemResource

```
XmlBeanDefinitionReader
```

Resource

MessageSource

DefaultResourceLoader

ApplicationEventPublisher

```
AbstractRefreshableApplicationContext
```

IOC容器的启动：refresh（）方法。

```
XmlBeanDefinitionReader
```

ResourceLoader：DefaultResourceLoader

BeanDefinition：

```
AbstractBeanDefinitionReader
BeanDefinitionDocumentReader
```

BeanDefinitionRegistry：

初始化的过程主要完成的工作是在Ioc容器中建立BeanDefinition的数据映射。



ManagedProperties

ManagedXxxxx



自定义标签：



spring中的Assert，断言。就是可以检测一下是否会触发某种状态。作为一个判断来使用。它可以抛出一个异常。在使用的时候指定一个需要检测的Boolean表达式，再指定一个需要抛出的信息即可。



ApplicationContextAware：实现了该接口的Bean可以访问Spring容器。