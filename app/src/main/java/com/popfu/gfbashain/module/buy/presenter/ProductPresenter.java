package com.popfu.gfbashain.module.buy.presenter;

import com.popfu.gfbashain.R;
import com.popfu.gfbashain.module.buy.bean.ProductItem;
import com.popfu.gfbashain.module.in.activity.ArticleItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengfu on 04/11/2017.
 */

public class ProductPresenter {




    public List<ProductItem> getData(){

        List<ProductItem> datas = new ArrayList<>() ;
        datas.add(new ProductItem("感受不到的电感辐射" , R.drawable.demo_v1 ,"生活" ,"989")) ;
        datas.add(new ProductItem("记忆珊瑚樵的消失" , R.drawable.demo_v2 ,"纪录片" ,"1024")) ;
        datas.add(new ProductItem("外国孩子的随意成长" , R.drawable.demo_v4 ,"纪录片" ,"124")) ;
        datas.add(new ProductItem("云层背后的『刀光剑影』" , R.drawable.demo_v3 ,"生活" ,"9089")) ;
        datas.add(new ProductItem("不敢直视未来" , R.drawable.demo_v5 ,"生活" ,"99")) ;
        datas.add(new ProductItem("记忆珊瑚樵的消失" , R.drawable.demo_v2 ,"纪录片" ,"1024")) ;
        datas.add(new ProductItem("感受不到的电感辐射" , R.drawable.demo_v1 ,"生活" ,"9890")) ;
        datas.add(new ProductItem("外国孩子的随意成长" , R.drawable.demo_v4 ,"纪录片" ,"124")) ;
        datas.add(new ProductItem("不敢直视未来" , R.drawable.demo_v5 ,"生活" ,"929")) ;
        datas.add(new ProductItem("云层背后的『刀光剑影』" , R.drawable.demo_v3 ,"生活" ,"9089")) ;

        return datas ;
    }
}
