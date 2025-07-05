package com.SGE.prototipo;

import com.SGE.SgeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = SgeApplication.class)
@ActiveProfiles("test") 
class SgeApplicationTests {

    @Test
    void contextLoads() {
    }
}