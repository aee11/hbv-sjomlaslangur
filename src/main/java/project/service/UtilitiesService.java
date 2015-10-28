package project.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by Alexander on 28.10.2015.
 */
public class UtilitiesService {
    private static DecimalFormat df = new DecimalFormat("#.#######");

    public static long hotness(Long ups, Long downs, Date date) {
        // See http://amix.dk/blog/post/19588
        Long score = ups - downs;
        double order = Math.log10(Math.max(Math.abs(score), 1));
        double sign = Math.signum(score);
        Long seconds = date.getTime() - 1134028003;
        return Long.parseLong(df.format(sign * order + (double) (seconds / 45000)));
    }
}
