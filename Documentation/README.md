* 可以将构造方法私有化 class RecycleAdapter private constructor
* 尽量多用private val
* private protect(只能用在类成员上) internal(module 权限) public
* data class
* 省略返回值类型有两种场景
  - 对属性赋值

  ```
   val age  = 3

	val age : Int  = 3

  ```
  - 对函数赋值，下面两个等价

  ```
    override fun getItemCount() = entityList.size

    override fun getItemCount() : Int {
        return entityList.size
    }

  ```
* 代理  Delegates.notNull()  自定义代理
* 集合和函数操作符
 - 集合
      * Iterable
      * MutableIterable
      * List
      * ...
- 函数操作符
      * 总数操作符 any all count fold foldRight forEach forEachIndexed max maxBy min minBy none reduce reduceRight sumBy
      * 过滤操作符 dropWhile dropLastWhile filter filterNot filterNotNull slice take takeLast takeWhile
      * 映射操作符 flatMap groupBy map mapIndexed mapNotNull
      * 元素操作符 contains elementAt elementAtOrElse elementAtOrNull first firstOrNull indexOf indexOfFirst last lastIndexOf lastOrNull single singleOrNull
      * 生产操作符 merge partition plus unzip
      * 顺序操作符 reverse sort sortBy sortDescending sortDescendingBy
* Elvis operator ?:
  - val a:Int? = null       val nName = a?.toString() ?: ""    val nName = a?.toString() ?: throw IllegalArgumentException()
* 流程控制
  - if 几乎和java的一样
  - when 为java中的switch，并且还可以使用 range 表达式

  		  ```
                (0 until mRootViewFlow.childCount step 1)
                .map { mRootViewFlow.getChildAt(it) }
                .forEach {
                    when (it) {
                        is CheckBox -> ToastUtil.showToast(it.isChecked.toString())
                        is TextView -> ToastUtil.showToast(it.text.toString())
                        is ViewGroup -> ToastUtil.showToast(it.childCount.toString())
                    }
                }

  		    ```

   - for 通常也和 range 结合

		   ```
		           for (index in 0..mRootViewFlow.childCount) {
		            print(index)
		        }

		   ```

   - while/do while 和java 类似
   - range ** 可以通过 step 设置步长 downTo 降低 看when的栗子

* 范型
   - let 去掉了无用的判空处理，相比较?.而言 可以执行代码块

		    ```
		    main_activity_rv?.let { ToastUtil.showToast(main_activity_rv.toString()) }
		    ```
   - apply 可以避免创建 builder的方式来使用，因为对象调用的函数可以根据自己的需要来初始化自己，然后apply函数会返回它同一个对象，可以针对对象连续设值，相当于build，不过模式更简洁

           ```
		    val textView = textView.apply {
	            text = "apply"
	            setTextColor(Color.RED)
	            textSize = 15f
	        	}
		    ```

   - with 我也不造 哈哈
* kotlin 中的类 默认都是 final 的，如果需要子类继承写为 open | abstract
* inner 声明的内部类才可以访问外部类的成员
* sealed 类 类似于枚举，只不过子类可以生成多个对象，另外 使用 when 的时候不用再写 else，因为sealed 限制了子类的继承关系，肯定全部覆盖了

           ```
           sealed class Fruit {
			    class Apple: Fruit()
			    class Banana: Fruit()
			    object Other: Fruit()
			}
			/**
			 * 生成 fruit 单例对象
			 */
			object FruitUtil {
			    fun getFruitNum(fruit: Fruit): Int = when (fruit) {
			        is Fruit.Apple -> 1
			        is Fruit.Banana -> 2
			        is Fruit.Other -> 3
			        // 不需要再写 else，因为密封类已经全部覆盖
			    }
			}

           ```
* object 关键字
   - 对象表达式，匿名内部类使用

   ```
		window.addMouseListener(object : MouseAdapter() {
			override fun mouseClicked(e: MouseEvent) {
			// ......
		}
			override fun mouseEntered(e: MouseEvent) {
			// ......
		} })
   ```

   - 对象声明（单例）

   ```
	   object DefaultListener : MouseAdapter() {
	    	override fun mouseClicked(e: MouseEvent) {
			// ......
		}
	    	override fun mouseEntered(e: MouseEvent) {
	       // ......
		} }

   ```