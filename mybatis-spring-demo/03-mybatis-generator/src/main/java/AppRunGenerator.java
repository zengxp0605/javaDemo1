import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：stanzeng
 * @Description：
 * @Date ：Created in 2020/3/31 4:34 下午
 * @Modified By：
 */
public class AppRunGenerator {

    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;

            File configFile = new File("03-mybatis-generator/src/main/resources/generatorConfig.xml");
            System.out.println(configFile.isFile());
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("TODO: 无法生成！！！？？？");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
