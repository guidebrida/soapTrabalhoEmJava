para rodar o client e gerar a pasta service

rodar o comando mvn install


se mudar algo no server(back) precisa der mvn clean + mvn install








[//]: # (------------)

[//]: # ()
[//]: # (OrderServiceService service = new OrderServiceService&#40;&#41;;)

[//]: # (OrderService orderService = service.getOrderServicePort&#40;&#41;;)

[//]: # ()
[//]: # (String address = "http://localhost:8081/orders";)

[//]: # (Endpoint.publish&#40;address, new OrderService&#40;&#41;&#41;;)

[//]: # (System.out.println&#40;"Published at address : "+address&#41;;)

[//]: # ()
[//]: # (<build>)

[//]: # (        <plugins>)

[//]: # (            <plugin>)

[//]: # (                <groupId>org.apache.maven.plugins</groupId>)

[//]: # (                <artifactId>maven-compiler-plugin</artifactId>)

[//]: # (                <version>3.7.0</version>)

[//]: # (                <configuration>)

[//]: # (                    <release>21</release>)

[//]: # (                </configuration>)

[//]: # (                <dependencies>)

[//]: # (                    <dependency>)

[//]: # (                        <groupId>org.ow2.asm</groupId>)

[//]: # (                        <artifactId>asm</artifactId>)

[//]: # (                        <version>9.1</version> <!-- Use newer version of ASM -->)

[//]: # (                    </dependency>)

[//]: # (                </dependencies>)

[//]: # (            </plugin>)

[//]: # (            <plugin>)

[//]: # (                <groupId>com.sun.xml.ws</groupId>)

[//]: # (                <artifactId>jaxws-maven-plugin</artifactId>)

[//]: # (                <version>3.0.0</version>)

[//]: # (                <executions>)

[//]: # (                    <execution>)

[//]: # (                        <goals>)

[//]: # (                            <goal>wsimport</goal>)

[//]: # (                        </goals>)

[//]: # (                    </execution>)

[//]: # (                </executions>)

[//]: # (                <configuration>)

[//]: # (                    <wsdlUrls>)

[//]: # (                        <wsdlUrl>http://localhost:8081/orders?wsdl</wsdlUrl>)

[//]: # (                    </wsdlUrls>)

[//]: # (                    <keep>true</keep>)

[//]: # (                    <packageName>com.k.service</packageName>)

[//]: # (                    <sourceDestDir>src/main/java</sourceDestDir>)

[//]: # (                </configuration>)

[//]: # (            </plugin>)

[//]: # ()
[//]: # (        </plugins>)

[//]: # ()
[//]: # (--add-opens java.base/jdk.internal.misc=ALL-UNNAMED)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (<?xml version="1.0" encoding="UTF-8"?>)

[//]: # (<project xmlns="http://maven.apache.org/POM/4.0.0")

[//]: # (xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance")

[//]: # (xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">)

[//]: # (<modelVersion>4.0.0</modelVersion>)

[//]: # ()
[//]: # (    <groupId>com.k</groupId>)

[//]: # (    <artifactId>server</artifactId>)

[//]: # (    <version>1.0-SNAPSHOT</version>)

[//]: # ()
[//]: # (    <properties>)

[//]: # (        <maven.compiler.source>21</maven.compiler.source>)

[//]: # (        <maven.compiler.target>21</maven.compiler.target>)

[//]: # (        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>)

[//]: # (    </properties>)

[//]: # ()
[//]: # (    <dependencies>)

[//]: # (        <dependency>)

[//]: # (            <groupId>jakarta.xml.ws</groupId>)

[//]: # (            <artifactId>jakarta.xml.ws-api</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (        </dependency>)

[//]: # (        <dependency>)

[//]: # (            <groupId>com.sun.xml.ws</groupId>)

[//]: # (            <artifactId>jaxws-rt</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (        </dependency>)

[//]: # ()
[//]: # (        <dependency>)

[//]: # (            <groupId>com.sun.xml.ws</groupId>)

[//]: # (            <artifactId>jaxws-ri</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (                <type>pom</type>)

[//]: # (        </dependency>)

[//]: # (    </dependencies>)

[//]: # ()
[//]: # (</project>)

[//]: # ()
[//]: # ()
[//]: # (package com.k.model;)

[//]: # ()
[//]: # (import java.util.ArrayList;)

[//]: # (import java.util.List;)

[//]: # ()
[//]: # (public class Order {)

[//]: # ()
[//]: # (    private int id;)

[//]: # (    private List<Product> products = new ArrayList<>&#40;&#41;;)

[//]: # (    private Address address;)

[//]: # (    private String status;)

[//]: # ()
[//]: # (    public Order&#40;&#41; {)

[//]: # ()
[//]: # (	})

[//]: # ()
[//]: # (	public Order&#40;int id, List<Product> products, Address address, String status&#41; {)

[//]: # ()
[//]: # (		this.id = id;)

[//]: # (		this.products = products;)

[//]: # (		this.address = address;)

[//]: # (		this.status = status;)

[//]: # (	})

[//]: # ()
[//]: # (	public int getId&#40;&#41; {)

[//]: # (		return id;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setId&#40;int id&#41; {)

[//]: # (		this.id = id;)

[//]: # (	})

[//]: # ()
[//]: # (	public List<Product> getProducts&#40;&#41; {)

[//]: # (		return products;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setProducts&#40;List<Product> products&#41; {)

[//]: # (		this.products = products;)

[//]: # (	})

[//]: # ()
[//]: # (	public Address getAddress&#40;&#41; {)

[//]: # (		return address;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setAddress&#40;Address address&#41; {)

[//]: # (		this.address = address;)

[//]: # (	})

[//]: # ()
[//]: # (	public String getStatus&#40;&#41; {)

[//]: # (		return status;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setStatus&#40;String status&#41; {)

[//]: # (		this.status = status;)

[//]: # (	})

[//]: # (})

[//]: # ()
[//]: # ()
[//]: # (<build>)

[//]: # (        <plugins>)

[//]: # (            <plugin>)

[//]: # (                <groupId>org.apache.maven.plugins</groupId>)

[//]: # (                <artifactId>maven-compiler-plugin</artifactId>)

[//]: # (                <version>3.7.0</version>)

[//]: # (                <configuration>)

[//]: # (                    <release>21</release>)

[//]: # (                </configuration>)

[//]: # (                <dependencies>)

[//]: # (                    <dependency>)

[//]: # (                        <groupId>org.ow2.asm</groupId>)

[//]: # (                        <artifactId>asm</artifactId>)

[//]: # (                        <version>9.1</version> <!-- Use newer version of ASM -->)

[//]: # (                    </dependency>)

[//]: # (                </dependencies>)

[//]: # (            </plugin>)

[//]: # (            <plugin>)

[//]: # (                <groupId>com.sun.xml.ws</groupId>)

[//]: # (                <artifactId>jaxws-maven-plugin</artifactId>)

[//]: # (                <version>3.0.0</version>)

[//]: # (                <executions>)

[//]: # (                    <execution>)

[//]: # (                        <goals>)

[//]: # (                            <goal>wsimport</goal>)

[//]: # (                        </goals>)

[//]: # (                    </execution>)

[//]: # (                </executions>)

[//]: # (                <configuration>)

[//]: # (                    <wsdlUrls>)

[//]: # (                        <wsdlUrl>http://localhost:8081/orders?wsdl</wsdlUrl>)

[//]: # (                    </wsdlUrls>)

[//]: # (                    <keep>true</keep>)

[//]: # (                    <packageName>com.k.service</packageName>)

[//]: # (                    <sourceDestDir>src/main/java</sourceDestDir>)

[//]: # (                </configuration>)

[//]: # (            </plugin>)

[//]: # ()
[//]: # (        </plugins>)

[//]: # (    </build>)

[//]: # (--add-opens java.base/jdk.internal.misc=ALL-UNNAMED   </build>)


para rodar o client e gerar a pasta service

rodar o comando mvn install


se mudar algo no server(back) precisa der mvn clean + mvn install








[//]: # (------------)

[//]: # ()
[//]: # (OrderServiceService service = new OrderServiceService&#40;&#41;;)

[//]: # (OrderService orderService = service.getOrderServicePort&#40;&#41;;)

[//]: # ()
[//]: # (String address = "http://localhost:8081/orders";)

[//]: # (Endpoint.publish&#40;address, new OrderService&#40;&#41;&#41;;)

[//]: # (System.out.println&#40;"Published at address : "+address&#41;;)

[//]: # ()
[//]: # (<build>)

[//]: # (        <plugins>)

[//]: # (            <plugin>)

[//]: # (                <groupId>org.apache.maven.plugins</groupId>)

[//]: # (                <artifactId>maven-compiler-plugin</artifactId>)

[//]: # (                <version>3.7.0</version>)

[//]: # (                <configuration>)

[//]: # (                    <release>21</release>)

[//]: # (                </configuration>)

[//]: # (                <dependencies>)

[//]: # (                    <dependency>)

[//]: # (                        <groupId>org.ow2.asm</groupId>)

[//]: # (                        <artifactId>asm</artifactId>)

[//]: # (                        <version>9.1</version> <!-- Use newer version of ASM -->)

[//]: # (                    </dependency>)

[//]: # (                </dependencies>)

[//]: # (            </plugin>)

[//]: # (            <plugin>)

[//]: # (                <groupId>com.sun.xml.ws</groupId>)

[//]: # (                <artifactId>jaxws-maven-plugin</artifactId>)

[//]: # (                <version>3.0.0</version>)

[//]: # (                <executions>)

[//]: # (                    <execution>)

[//]: # (                        <goals>)

[//]: # (                            <goal>wsimport</goal>)

[//]: # (                        </goals>)

[//]: # (                    </execution>)

[//]: # (                </executions>)

[//]: # (                <configuration>)

[//]: # (                    <wsdlUrls>)

[//]: # (                        <wsdlUrl>http://localhost:8081/orders?wsdl</wsdlUrl>)

[//]: # (                    </wsdlUrls>)

[//]: # (                    <keep>true</keep>)

[//]: # (                    <packageName>com.k.service</packageName>)

[//]: # (                    <sourceDestDir>src/main/java</sourceDestDir>)

[//]: # (                </configuration>)

[//]: # (            </plugin>)

[//]: # ()
[//]: # (        </plugins>)

[//]: # ()
[//]: # (--add-opens java.base/jdk.internal.misc=ALL-UNNAMED)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (<?xml version="1.0" encoding="UTF-8"?>)

[//]: # (<project xmlns="http://maven.apache.org/POM/4.0.0")

[//]: # (xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance")

[//]: # (xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">)

[//]: # (<modelVersion>4.0.0</modelVersion>)

[//]: # ()
[//]: # (    <groupId>com.k</groupId>)

[//]: # (    <artifactId>server</artifactId>)

[//]: # (    <version>1.0-SNAPSHOT</version>)

[//]: # ()
[//]: # (    <properties>)

[//]: # (        <maven.compiler.source>21</maven.compiler.source>)

[//]: # (        <maven.compiler.target>21</maven.compiler.target>)

[//]: # (        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>)

[//]: # (    </properties>)

[//]: # ()
[//]: # (    <dependencies>)

[//]: # (        <dependency>)

[//]: # (            <groupId>jakarta.xml.ws</groupId>)

[//]: # (            <artifactId>jakarta.xml.ws-api</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (        </dependency>)

[//]: # (        <dependency>)

[//]: # (            <groupId>com.sun.xml.ws</groupId>)

[//]: # (            <artifactId>jaxws-rt</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (        </dependency>)

[//]: # ()
[//]: # (        <dependency>)

[//]: # (            <groupId>com.sun.xml.ws</groupId>)

[//]: # (            <artifactId>jaxws-ri</artifactId>)

[//]: # (            <version>3.0.0</version>)

[//]: # (                <type>pom</type>)

[//]: # (        </dependency>)

[//]: # (    </dependencies>)

[//]: # ()
[//]: # (</project>)

[//]: # ()
[//]: # ()
[//]: # (package com.k.model;)

[//]: # ()
[//]: # (import java.util.ArrayList;)

[//]: # (import java.util.List;)

[//]: # ()
[//]: # (public class Order {)

[//]: # ()
[//]: # (    private int id;)

[//]: # (    private List<Product> products = new ArrayList<>&#40;&#41;;)

[//]: # (    private Address address;)

[//]: # (    private String status;)

[//]: # ()
[//]: # (    public Order&#40;&#41; {)

[//]: # ()
[//]: # (	})

[//]: # ()
[//]: # (	public Order&#40;int id, List<Product> products, Address address, String status&#41; {)

[//]: # ()
[//]: # (		this.id = id;)

[//]: # (		this.products = products;)

[//]: # (		this.address = address;)

[//]: # (		this.status = status;)

[//]: # (	})

[//]: # ()
[//]: # (	public int getId&#40;&#41; {)

[//]: # (		return id;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setId&#40;int id&#41; {)

[//]: # (		this.id = id;)

[//]: # (	})

[//]: # ()
[//]: # (	public List<Product> getProducts&#40;&#41; {)

[//]: # (		return products;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setProducts&#40;List<Product> products&#41; {)

[//]: # (		this.products = products;)

[//]: # (	})

[//]: # ()
[//]: # (	public Address getAddress&#40;&#41; {)

[//]: # (		return address;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setAddress&#40;Address address&#41; {)

[//]: # (		this.address = address;)

[//]: # (	})

[//]: # ()
[//]: # (	public String getStatus&#40;&#41; {)

[//]: # (		return status;)

[//]: # (	})

[//]: # ()
[//]: # (	public void setStatus&#40;String status&#41; {)

[//]: # (		this.status = status;)

[//]: # (	})

[//]: # (})

[//]: # ()
[//]: # ()
[//]: # (<build>)

[//]: # (        <plugins>)

[//]: # (            <plugin>)

[//]: # (                <groupId>org.apache.maven.plugins</groupId>)

[//]: # (                <artifactId>maven-compiler-plugin</artifactId>)

[//]: # (                <version>3.7.0</version>)

[//]: # (                <configuration>)

[//]: # (                    <release>21</release>)

[//]: # (                </configuration>)

[//]: # (                <dependencies>)

[//]: # (                    <dependency>)

[//]: # (                        <groupId>org.ow2.asm</groupId>)

[//]: # (                        <artifactId>asm</artifactId>)

[//]: # (                        <version>9.1</version> <!-- Use newer version of ASM -->)

[//]: # (                    </dependency>)

[//]: # (                </dependencies>)

[//]: # (            </plugin>)

[//]: # (            <plugin>)

[//]: # (                <groupId>com.sun.xml.ws</groupId>)

[//]: # (                <artifactId>jaxws-maven-plugin</artifactId>)

[//]: # (                <version>3.0.0</version>)

[//]: # (                <executions>)

[//]: # (                    <execution>)

[//]: # (                        <goals>)

[//]: # (                            <goal>wsimport</goal>)

[//]: # (                        </goals>)

[//]: # (                    </execution>)

[//]: # (                </executions>)

[//]: # (                <configuration>)

[//]: # (                    <wsdlUrls>)

[//]: # (                        <wsdlUrl>http://localhost:8081/orders?wsdl</wsdlUrl>)

[//]: # (                    </wsdlUrls>)

[//]: # (                    <keep>true</keep>)

[//]: # (                    <packageName>com.k.service</packageName>)

[//]: # (                    <sourceDestDir>src/main/java</sourceDestDir>)

[//]: # (                </configuration>)

[//]: # (            </plugin>)

[//]: # ()
[//]: # (        </plugins>)

[//]: # (    </build>)

[//]: # (--add-opens java.base/jdk.internal.misc=ALL-UNNAMED   </build>)
