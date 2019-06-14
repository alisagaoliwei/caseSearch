package com.greatsoft.casecheck.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Description:
 * @Author: yangzhanbiao
 * @CreateDate: 2019/5/7 12:54 PM
 */

public class SerialNoUtil {

    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmssSSS");
        }
    };
    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCALA = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyMM");
        }
    };

    public static String getSerialNo() {
        StringBuffer sb = new StringBuffer(DATE_FORMAT_THREAD_LOCAL.get().format(new Date()));
        int nextInt = ThreadLocalRandom.current().nextInt(1000);
        sb.append(nextInt);
        int len = sb.length();

        for (int i = len; i < 20; i++) {
            sb = sb.append("0");
        }
        return sb.toString();
    }

    public static String getSerialNo(String beginTag) {
        StringBuffer sb = null;
        if (StringUtils.isNoneBlank(beginTag)) {
            sb = new StringBuffer(beginTag + DATE_FORMAT_THREAD_LOCAL.get().format(new Date()));
        } else {
            sb = new StringBuffer(DATE_FORMAT_THREAD_LOCAL.get().format(new Date()));
        }
        int nextInt = ThreadLocalRandom.current().nextInt(1000);
        sb.append(nextInt);
        int len = sb.length();

        for (int i = len; i < 20; i++) {
            sb = sb.append("0");
        }
        return sb.toString();
    }

    /**
     * 生成八位随机数
     *
     * @return
     */
    public static String getEightNo() {
        String no = "";
        //初始化备选数组
        int[] defaultNums = new int[10];
        for (int i = 0; i < defaultNums.length; i++) {
            defaultNums[i] = i;
        }

        Random random = new Random();
        int[] nums = new int[LENGTH];
        //默认数组中可以选择的部分长度
        int canBeUsed = 10;
        //填充目标数组
        for (int i = 0; i < nums.length; i++) {
            //将随机选取的数字存入目标数组
            int index = random.nextInt(canBeUsed);
            nums[i] = defaultNums[index];
            //将已用过的数字扔到备选数组最后，并减小可选区域
            swap(index, canBeUsed - 1, defaultNums);
            canBeUsed--;
        }
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                no += nums[i];
            }
        }
        return no;
    }

    private static final int LENGTH = 8;

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static String generateNumber2() {
        String no = "";
        int num[] = new int[8];
        int c = 0;
        for (int i = 0; i < 8; i++) {
            num[i] = new Random().nextInt(10);
            c = num[i];
            for (int j = 0; j < i; j++) {
                if (num[j] == c) {
                    i--;
                    break;
                }
            }
        }
        if (num.length > 0) {
            for (int i = 0; i < num.length; i++) {
                no += num[i];
            }
        }
        return no;
    }

}



