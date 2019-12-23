# Intent
Intent参数传递
## 1、	putExtra（）方法  
Android 重载的putExtra()方法用来传递参数
都包含2个参数，

	name：表示传递的数据名称，
	value：表示传递的数据信息。
通过putExtra（）方法将传递的数据存储在Intent对象后，
通过getXxxExtra()方法来获取到。
例：

    Intent intent=new Intent（）；
    //设置跳转到的Activity
    intent.setClass(MainActivity.this,SecondActivioty.class);
    intent.putExtra(“name”,”张三”);
    startActivity(intent);

此时，在SecondActivioty中可以通过getXxxExtra（）方法来获取传递过来的数据。

    Intent intent=new Intent（）；
    String name=intent.getStringExtra(“name”);
## 2、	使用Bundle类传递数据
Bundle类与Map接口比较类似，都是通过键值对的形势来保存数据。

首先使用Bunde对象保存数据，
接着通过putExtra（）方法将这些数据封装到Intent对象中，
并传递到SecondActivioty中
例：

    Intent  intent=new Intent();
    Intent.setClass(this, SecondActivioty.class); //设置跳转到的Activity
    Bundle bunde=new Bundle();
    Bunde.putString(“name”,”张三”);
    startActivity(intent);
    
在SecondActivioty中获取数据

    Bundle bundle=getIntent.getExtras();  //获取Bundle对象
    String name=bundle.getString(“name”);
## 3、	Activity之间的数据回传
### a.	startActivityForResult()方法
具体介绍如下：

    startActivityForResult（Intent intent，int requeststCode）
    
该方法用于开启一个Activity，当开启的Activity销毁时，返回一个参数
### b.	setResult（int resultCode，Intent intent）方法：

用于携带数据进行回传，改方法有两个参数

    第一个参resultCode表示返回码，用于标识返回的数据来自哪一个Activity
    第二个参数intent表示用于鞋带数据并回传到上一个页面。
    还需要一个finish（）;用来关闭当前Activity 
### c.	onActivityResult（）方法
具体介绍如下：

    onActivityResult（int requestCode，int resultCode，Intent intent）
    onActivityResult（）方法用于接收回传的数据，并根据传递的参数requestCode、resultCode来表别数据的来源
