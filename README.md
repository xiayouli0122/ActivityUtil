 [ ![Download](https://api.bintray.com/packages/yuri/maven/activity_util_x/images/download.svg) ](https://bintray.com/yuri/maven/activity_util_x/_latestVersion)
 
# ActivityUtil
ActivityUtil是一个封装Activity跳转的工具类

# Gradle
```
dependencies {
    implementation 'com.yuri.activity:activity_util:1.0.6'
    ...
}
```

# 功能

* 不再需要重写onActivityResult代码
* 链式代码结构，所见即所得

#使用说明
简单的startActivity跳转示例
```
ActivityUtil.with(MainActivity@this)
        .activity(TestActivity::class.java) //跳转目标
        .start()
```

带参数的startActivity跳转示例
```
 ActivityUtil.with(MainActivity@this)
        .activity(TestActivity::class.java) //跳转目标
        .withString("text", "startActivity")
        .start()
```

简单的startActivityForResult跳转示例

```
ActivityUtil.with(MainActivity@this)
        .activity(TestActivity::class.java)
        .withString("text", "startActivityForResult")
        .startResult()
        .filter(OnResultFilterFunc()) //过滤RESULT_CANCEL，只有RESULT_OK的才会回调
        .subscribe {
            val data = it.data
            val text = data?.getStringExtra("result")
            textViewResult.text = text
        }
```

更多startActivityForResult跳转示例
```
val list = arrayListOf<String>()
list.add("Test")
list.add("for")
list.add("activity")
val bundle = Bundle()
bundle.putStringArrayList("list", list)
ActivityUtil.with(MainActivity@this)
        .activity(TestActivity::class.java)
        .withString("text", "startActivityForResult bundle")
        .withBundle(bundle)
        .startResult()
        .filter(OnResultFilterFunc())
        .subscribe {
            val data = it.data
            val text = data?.getStringExtra("result")
            textViewResult.text = text
        }
```

默认startActivityForResult是可以不需要设置requestCode的、

如果需要可以这样做
```
ActivityUtil.with(MainActivity@this)
        .activity(TestActivity::class.java)
        .requestCode(123)
        .withString("text", "startActivityForResult")
        .startResult()
        .filter(OnResultFilterFunc())
        .subscribe {
            if (it.requestCode == 123) {
                val data = it.data
                val text = data?.getStringExtra("result")
                textViewResult.text = text
            }
        }
```
