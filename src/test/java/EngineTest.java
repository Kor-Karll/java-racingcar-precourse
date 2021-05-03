import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {
    Engine engine = new Engine();

    @Test
    void getRandomPower() {
        int randomPower = engine.getRandomPower();
        assertThat(randomPower > 9).isFalse();
    }
}