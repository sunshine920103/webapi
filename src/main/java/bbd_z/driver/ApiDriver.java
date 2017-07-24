package bbd_z.driver;

import bbd_z.server.ApiServer;
import info.bbd.utils.driver.ProgramDriver;

/**
 * 驱动类
 *
 * @author rex
 *
 */
public class ApiDriver {
        /**
         * 主函数
         */
        public static void main(String[] args) {

            int exitCode = -1;
            ProgramDriver pgd = new ProgramDriver();
            try {
                // 运行在hefei07机器上
                pgd.addClass("ApiServer", ApiServer.class, "搜索查询接口");
                pgd.driver(args);
                // Success
                exitCode = 0;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }

            System.exit(exitCode);

        }

}
