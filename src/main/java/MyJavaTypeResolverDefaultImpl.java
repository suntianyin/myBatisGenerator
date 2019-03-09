import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

public class MyJavaTypeResolverDefaultImpl extends JavaTypeResolverDefaultImpl {
 
    public MyJavaTypeResolverDefaultImpl() {
        super();
        //把数据库的 VARCHAR 映射成 String
        super.typeMap.put(Types.OTHER, new JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
//        super.typeMap.put(Types.DECIMAL, new JdbcTypeInformation("NUMBER", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
