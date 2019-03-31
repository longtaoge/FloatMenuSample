/*
 * Copyright (c) 2016, Shanghai YUEWEN Information Technology Co., Ltd.
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  Neither the name of Shanghai YUEWEN Information Technology Co., Ltd. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY SHANGHAI YUEWEN INFORMATION TECHNOLOGY CO., LTD. AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.yw.game.floatmenu.demo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.yw.game.floatmenu.customfloat.BaseFloatDailog;

public class MainActivity extends Activity {


    private Activity mActivity;

    String HOME = "首页";
    String FEEDBACK = "客服";
    String MESSAGE = "消息";

    String[] MENU_ITEMS = {HOME, FEEDBACK, MESSAGE};

    private int[] menuIcons = new int[]{R.drawable.yw_menu_account, R.drawable.yw_menu_fb, R.drawable.yw_menu_msg};

    BaseFloatDailog mBaseFloatDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mActivity = this;

    }


    @Override
    protected void onResume() {
        super.onResume();


        if (mBaseFloatDailog != null) return;

        mBaseFloatDailog = new MyFloatDialog(this);
        mBaseFloatDailog.show();

    }


    private int dip2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    @Override
    protected void onPause() {
        super.onPause();
        hideFloat();
    }

    @Override
    protected void onDestroy() {
        destroyFloat();
        super.onDestroy();

        if (mBaseFloatDailog != null) mBaseFloatDailog.dismiss();

    }


    public void hideFloat() {

    }

    public void destroyFloat() {

        mActivity = null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (mBaseFloatDailog != null) mBaseFloatDailog.onConfigurationChanged(newConfig);
    }
}
