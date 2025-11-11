package com.github.tusharepro.core;

import com.github.tusharepro.core.bean.Daily;
import com.github.tusharepro.core.bean.StockBasic;
import com.github.tusharepro.core.entity.DailyEntity;
import com.github.tusharepro.core.entity.StockBasicEntity;
import com.github.tusharepro.core.http.Request;
import org.junit.jupiter.api.Test;

class TushareProServiceTest {

    @Test
    void daily() {
        String token = System.getenv("TUSHARE_API_TOKEN");
        TusharePro.setGlobal(new TusharePro.Builder().setToken(token).build());
        try {
            // 打印 上海交易所所有上市的沪股通股票 信息
            TushareProService.daily(new Request<DailyEntity>() {
                    }  // 使用全局配置
                            .allFields()  // 所有字段
                            .param(Daily.Params.ts_code.value("000001.SZ"))  // 参数
                            .param(Daily.Params.trade_date.value("20251110"))
                            )  // 参数
                    .forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}