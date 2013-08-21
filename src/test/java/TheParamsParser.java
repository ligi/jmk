import org.junit.Test;
import org.ligi.ufo.MKParamsParser;

import static org.fest.assertions.Assertions.assertThat;

public class TheParamsParser {

    @Test
    public void shouldReturnTooOldFor72() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(new int[] {1,72});

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.TOO_OLD);
    }

    @Test
    public void shouldReturnTooNewFor96() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(new int[] {1,96});

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.TOO_NEW);
    }


    @Test
    public void shouldBeCompatibleFor95() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(new int[] {1,92});

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.COMPATIBLE);
    }
    @Test
    public void shouldBeCompatibleForDefault() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(MKParamsParser.default_params[0]);

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.COMPATIBLE);
    }
}
