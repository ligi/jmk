package org.ligi.ufo.tests;

import org.ligi.ufo.MKHelper;

public class MKHelperTests {

    public static int[] getByteArr(int[] tmp_arr) {
        int[] res = new int[tmp_arr.length];
        for (int i = 0; i < tmp_arr.length; i++)
            res[i] = (tmp_arr[i]);
        return tmp_arr;
    }

    public static String isConvertionSane() {
        int[] tmp_arr = new int[4];
        /*
        MKHelper.int16ToByteArr(0, tmp_arr, 0);
			
		if (0!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "0->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));
		
		MKHelper.int16ToByteArr(1, tmp_arr, 0);
		
		if (1!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "1->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));
		
		MKHelper.int16ToByteArr(-0, tmp_arr, 0);
		
		if (-0!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "-0->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));
		*/
		/*
		MKHelper.int16ToByteArr(-2, tmp_arr, 0);
		
		if (-23!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "-23->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));

		MKHelper.int16ToByteArr(-23, tmp_arr, 0);
		
		if (-23!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "-23->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));
		
		*/
        String res = "";
        for (int val : new int[]{100, 10, 1, 0, -1, -2, -3, -5, -23}) {
            MKHelper.int16ToByteArr(val, tmp_arr, 0);
            res += "" + val + "->" + MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)) + ";";
            //if (-2!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
            //return "-2->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));

        }
		/*
		MKHelper.int16ToByteArr(-1, tmp_arr, 0);
		
		if (-1!=MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr)))
			return "-1->"+MKHelper.parse_signed_arr_2(0, getByteArr(tmp_arr));
		*/
        return res;
    }
}
