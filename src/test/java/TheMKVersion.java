import org.junit.Test;
import org.ligi.androidhelper.test.TestSeeds;
import org.ligi.ufo.MKHelper;
import org.ligi.ufo.MKVersion;
import org.ligi.ufo.WayPoint;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TheMKVersion {

    private final int[] FAKE_DATA = {100, 0, 1, 23, 56, 11, 12};

    @Test
    public void should_be_unknown_on_init() {
       MKVersion tested=new MKVersion();

       assertThat(tested.known).isEqualTo(false);
    }

    @Test
    public void should_be_known_after_set() {
        MKVersion tested=new MKVersion();
        tested.set_by_mk_data(FAKE_DATA,10);
        assertThat(tested.known).isEqualTo(true);
    }

    @Test
    public void should_remember_slave_addr() {
        MKVersion tested=new MKVersion();
        tested.set_by_mk_data(FAKE_DATA,23);
        assertThat(tested.getSlaveAddr()).isEqualTo(23);
    }

}
