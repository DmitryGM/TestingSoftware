package task4.tests.integration;

import org.junit.jupiter.api.Test;
import task4.calculator.Function;
import task4.calculator.logarithmic.FunLog;
import task4.calculator.logarithmic.Log;
import task4.calculator.logarithmic.Log2;
import task4.calculator.trigonometric.*;
import task4.tests.Table;
import task4.tests.Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFun_Step_3 extends Tests {
    {
        this.funTrg = new FunTrg(new Tan(Table.sin, new Cos(Table.sin)), new Sec(new Cos(Table.sin)), new Csc(Table.sin));
        this.funLog = new FunLog(Table.log, new Log2(Table.log));

        this.fun = new Function(funLog, funTrg);
    }

    @Test
    public void test() {
        for (double x : Table.xNegative) {
            double y1 = this.fun.calc(x);
            double y2 = Table.fun.calc(x);
            assertTrue(Math.abs(y1 - y2) < eps, message(x, y1, y2));
        }
    }
}
