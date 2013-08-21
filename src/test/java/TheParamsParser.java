import org.junit.Test;
import org.ligi.ufo.MKParamsParser;

import static org.fest.assertions.Assertions.assertThat;

public class TheParamsParser {

    private int[] getFakeArrForVersion(int version) {
        return new int[] {1,version, 79, 1, 2, 3, 4, 5, 6, 7, 8, 104, 30, 30, 251, 10, 20, 30, 5, 64, 14, 16, 12, 8, 230, 27, 128, 80, 150, 5, 33, 35, 30, 0, 32, 0, 0, 0, 0, 100, 40, 0, 250, 100, 40, 0, 250, 3, 50, 90, 50, 90, 80, 1, 78, 78, 16, 0, 100, 0, 0, 0, 0, 95, 15, 243, 15, 170, 170, 252, 100, 90, 90, 90, 75, 75, 75, 0, 6, 8, 90, 30, 100, 100, 4, 0, 0, 0, 0, 0, 0, 0, 83, 112, 111, 114, 116, 0, 0, 78, 111, 114, 109, 97, 79, 1, 2, 3, 4, 5, 6, 7, 8, 104, 30, 30, 251, 10, 20, 30, 5, 64, 14, 16, 12, 8, 230, 27, 128, 80, 150, 5, 33, 35, 30, 0, 32, 0, 0, 0, 0, 100, 40, 0, 250, 100, 40, 0, 250, 3, 50, 90, 50, 90, 80, 1, 78, 78, 16, 0, 100, 0, 0, 0, 0, 95, 15, 243, 15, 170, 170, 252, 100, 90, 90, 90, 75, 75, 75, 0, 6, 8, 90, 30, 100, 100, 4, 0, 0, 0, 0, 0, 0, 0, 83, 112, 111, 114, 116, 0, 0, 78, 111, 114, 109, 97};
    }

    @Test
    public void shouldReturnTooOldFor72() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(getFakeArrForVersion(72));

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.TOO_OLD);
    }

    @Test
    public void shouldReturnCompatibleFor73() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(getFakeArrForVersion(73));

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.COMPATIBLE);
    }

    @Test
    public void shouldReturnTooNewFor96() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(getFakeArrForVersion(96));

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.TOO_NEW);
    }


    @Test
    public void shouldBeCompatibleFor95() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(getFakeArrForVersion(95));

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.COMPATIBLE);
    }

    @Test
    public void shouldBeInCompatibleFor93() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(new int[] {1,93 });

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.INCOMPATIBLE);
    }


    @Test
    public void shouldBeCompatibleForDefault() {
        MKParamsParser tested=new MKParamsParser();
        tested.set_by_mk_data(MKParamsParser.default_params[0]);

        //test
        assertThat(tested.compatibility).isEqualTo(MKParamsParser.Compatibility.COMPATIBLE);
    }
}
