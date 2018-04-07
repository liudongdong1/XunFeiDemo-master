package com.itheima.xunfeidemo;

import android.app.Activity;
import android.util.Log;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by lenovo on 2018/4/7.
 */

public class Speek {
    protected SpeechSynthesizer mTts;

    private Activity activity;

    private static final String TAG = "Speek";

    public Speek(Activity activity){
        this.activity=activity;

        initTTs();
    }
    public void Speeking(String text)
    {
        //3.开始合成
        mTts.startSpeaking(text, null);
    }
    public void initTTs()
    {
        // 将“12345678”替换成您申请的 APPID，申请地址： http://www.xfyun.cn
        // 请勿在“ =”与 appid 之间添加任务空字符或者转义符  初始化SDK
        SpeechUtility.createUtility(activity, SpeechConstant.APPID +"=5ac39c04");
        //1.创建 SpeechSynthesizer 对象, 第二个参数： 本地合成时传 InitListener
         mTts= SpeechSynthesizer.createSynthesizer(activity, null);
        //2.合成参数设置，详见《 MSC Reference Manual》 SpeechSynthesizer 类
        //设置发音人（更多在线发音人，用户可参见 附录13.2
        mTts.setParameter(SpeechConstant.VOICE_NAME, "vixy"); //设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "45");//设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围 0~100
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端
        //设置合成音频保存位置（可自定义保存位置），保存在“./sdcard/iflytek.pcm”
        //保存在 SD 卡需要在 AndroidManifest.xml 添加写 SD 卡权限//仅支持保存为 pcm 和 wav 格式， 如果不需要保存合成音频，注释该行代码
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./sdcard/iflytek.pcm");

    }
    private void print(String message) {
        Log.i(TAG, message);
    }
    private void checkResult(int result, String method) {
        if (result != 0) {
            print("error code :" + result + " method:" + method + ", 错误码文档:http://yuyin.baidu.com/docs/tts/122 ");
        }
    }
    public void Destory(){
        if (mTts != null){
            mTts.stopSpeaking();
            mTts.destroy();
            mTts = null;
            print("释放资源成功");
        }
    }

}
