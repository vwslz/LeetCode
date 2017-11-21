public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        // probably compare the chars directly would do faster than parseInt()
        String[] s_version1 = version1.split("\\."), s_version2 = version2.split("\\.");
        int n_min = (s_version1.length < s_version2.length ? s_version1.length : s_version2.length);
        int n_max = (s_version1.length > s_version2.length ? s_version1.length : s_version2.length);

        for (int i_n_min = 0; i_n_min < n_min; i_n_min++) {
            if (toInt(s_version1[i_n_min]) > toInt(s_version2[i_n_min]))
                return 1;
            else if (toInt(s_version1[i_n_min]) < toInt(s_version2[i_n_min]))
                return -1;
        }
        for (int i_n_max = n_min; i_n_max < n_max; i_n_max++) {
            if (s_version1.length > s_version2.length) {
                if (toInt(s_version1[i_n_max]) > 0)
                    return 1;
                else if (toInt(s_version1[i_n_max]) < 0)
                    return -1;
            } else if (s_version1.length < s_version2.length) {
                if (toInt(s_version2[i_n_max]) < 0)
                    return 1;
                else if (toInt(s_version2[i_n_max]) > 0)
                    return -1;
            }
        }
        return 0;
    }

    public int toInt(String s) {
        if(s.length() > 0)
            return Integer.parseInt(s);
        else
            return 0;
    }
}

