JVM  virtual machine虚拟java环境， JDK Java程序工具包， jre  running environment运行Java的环境。

jre包括jvm和核心类库util等， 再加上开发工具比如java.exe，javac.exe.javaw.exe共同组成JDK

数据类型：byte,short,int,long;float,double,boolean,char在栈上分配内存；对应有包装类，在对象环境中使用，动态分配内存，在堆上创建，包含方法和字段，同时占有更多内存；提供了自动autoboxing和unboxing功能，转换更加方便。

Integer i=43; int p=i;整型包装类对象比较用equals

从小到大自动类型转换，从大到小强制  小类型 变量名=大类型值；自增自减复合赋值底层做了优化，自动强制转换

static 被类所有实例共享的静态变量；通过类名访问；普通方法需要通过对象来调用，而静态方法  **不依赖对象** ，可以直接通过类名调用。**不能访问非静态成员** ：静态方法内部不能直接访问实例变量或实例方法，因为它不知道“哪个对象”的变量。

OOP, or Object-Oriented Programming, is a programming paradigm where we model real-world entities as objects. Each object contains **data** (attributes) and **behavior** (methods), and we use concepts like **encapsulation, inheritance, polymorphism, and abstraction** to structure and organize code

**Encapsulation 封装  **把数据和方法封装在对象内部，隐藏实现细节，对外只提供接口。“Encapsulation helps protect data and control access, usually by using private variables and public getter/setter methods.”

**Inheritance 继承 **子类可以继承父类的属性和方法，实现代码复用。“Inheritance allows us to create hierarchies of classes, reuse code, and extend functionality without rewriting existing code.”

**Polymorphism 多态 **不同对象可以通过相同接口表现不同的行为（方法重写或方法重载）。“Polymorphism allows objects to be treated as instances of their parent class, while still using their own overridden methods.”

**Abstraction 抽象 **只暴露必要的接口，隐藏具体实现。“Abstraction lets us define what an object can do without specifying how it does it, for example using abstract classes or interfaces.”

接口和抽象类区别：1.定义：接口是抽象类型，默认抽象，只包含static fina常量和抽象方法，抽象类是一个类，可以有抽象方法和具体方法，不能实例化；2：接口支持多继承，抽象只能继承一个；3.接口没有构造器，类实现接口必须定义所有方法，抽象类可以包含构造器，用于初始化抽象类的实例，子类实例化可以调用父类；4.接口方法默认abstract, static final; 抽象类默认是protected的；5.类可以实现多个接口，只能继承一个抽象类；

构造方法不能重写

public所有类可见；protected同一个包和子类；没有修饰符默认包访问，private不能访问

static  变量 所有实例共享；方法，通过类名调用，代码块，类加载时执行一次，静态内部类，可以被类直接访问。静态成员无法访问非静态成员，因为它依赖于实例

final修饰变量，方法和类时候，不可变。变量不能改，方法不可被重写，类不能被继承
