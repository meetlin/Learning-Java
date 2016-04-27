package cn.echohce.design_pattern;

/**
 * Created by lin on 2016/4/26.
 */

/**
 * 手机类，需要充电
 */
class Mobile {
    public void charge(V5Power power) {
        int provideV5Power = power.provideV5Power();
        System.out.println("手机：我需要5V电压，现在为 " + provideV5Power + " V");
    }
}

/**
 * 提供5v电压的接口
 */
interface V5Power {
    public int provideV5Power();
}

/**
 * 家用220V交流电
 */

class V220Power {
    public int providerV220Power() {
        System.out.println("实际存在的接口：提供了220V的交流电压");
        return 220;
    }
}

/**
 * 完成适配器 220V -> 5V
 */
class V5PowerAdapter implements V5Power {
    private V220Power v220Power;

    public V5PowerAdapter(V220Power v220Power) {
        this.v220Power = v220Power;
    }

    @Override
    public int provideV5Power() {
        int power = v220Power.providerV220Power();
        // 处理逻辑。。。
        System.out.println("适配器：成功适配220V->5V");
        return 5;
    }
}

/**
 *  主程序
 */
public class adapter {
    public static void main(String[] args) {
        Mobile nexus = new Mobile();
        V5Power v5Power = new V5PowerAdapter(new V220Power());
        nexus.charge(v5Power);
    }
}

