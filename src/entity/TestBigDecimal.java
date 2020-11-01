package entity;/*
 * @Author 高凌峰
 * @Date 2020-11-01 16:56
 */

import java.math.BigDecimal;
public class TestBigDecimal {
    private String name;
    private BigDecimal overRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getOverRate() {
        return overRate;
    }

    public void setOverRate(BigDecimal overRate) {
        this.overRate = overRate;
    }

    @Override
    public String toString() {
        return "TestBigDecimal{" +
                "name='" + name + '\'' +
                ", overRate=" + overRate +
                '}';
    }
}
