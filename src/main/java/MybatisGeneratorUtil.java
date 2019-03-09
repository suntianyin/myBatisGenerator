

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
 
public class MybatisGeneratorUtil {
 
	public static void main(String[] args) throws Exception {
		   generator();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(sdf.parse("2018-06-25 00:00:00")));
//		String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	private static void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File(MybatisGeneratorUtil.class.getResource("/generatorConfig1.xml").getFile());
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
		   
		   System.out.println("代码生成完毕>>>>>>>>>>>>");
	}
 
}
