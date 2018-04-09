#springboot freemarker 部分配置

###spring.freemarker.allow-request-override=false 
设置HttpServletRequest属性是否被允许覆盖（隐藏）控制器生成的相同名称的模型属性。
###spring.freemarker.allow-session-override=false
设置HttpSession属性是否被允许覆盖（隐藏）控制器生成的同名的模型属性。
###spring.freemarker.cache=false
是否开启模板缓存
###spring.freemarker.charset=UTF-8
模版编码
###spring.freemarker.check-template-location=true 
检查模板位置是否存在
###spring.freemarker.content-type=text/html 
Content-Type值
###spring.freemarker.enabled=true 
是否启用模版
###spring.freemarker.expose-request-attributes=false 
在与模板合并之前，确定是否应该将所有请求属性添加到模版中
###spring.freemarker.expose-session-attributes=false
设置是否所有HttpSession属性都应该在与模板合并之前添加到模版中。
###spring.freemarker.prefix= 
模版前缀路径
###spring.freemarker.suffix= 
模版文件后缀
###spring.freemarker.template-loader-path=classpath:/templates/ 
模板路径的逗号分隔列表