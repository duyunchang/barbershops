/**
 * 针对org.apache.commons.codec.binary.Base64，
 * 需要导入架包commons-codec-1.9（或commons-codec-1.8等其他版本）
 * 官方下载地址：http://commons.apache.org/proper/commons-codec/download_codec.cgi
 */

/**
 * 提供接收和推送给公众平台消息的加解密接口(UTF8编码的字符串).
 * <ol>
 * 	<li>第三方回复加密消息给公众平台</li>
 * 	<li>第三方收到公众平台发送的消息，验证消息的安全性，并对消息进行解密。</li>
 * </ol>
 * 说明：异常java.security.InvalidKeyException:illegal Key Size的解决方案
 * <ol>
 * 	<li>在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
 *      http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html</li>
 * 	<li>下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt</li>
 * 	<li>如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件</li>
 * 	<li>如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件</li>
 * </ol>
 */

 	关于这一段html文件我简单介绍一下，首先通过xmlns:th="http://www.thymeleaf.org"导入命名空间，在后期时候的时候，由于html本身是静态视图，
 在使用相关属性的时候加上th:前缀可以使之变为动态视图。th:href="@{bootstrap/css/bootstrap.min.css}"表示引用Web静态资源。OK，这是head部分。
 	body部分整体上分为了两大块，第一块显示我那个单独的Person对象，第二部分显示List集合中的Person对象。div的样式这个没啥好说的，
 照着Bootstrap的官网写就行了，th:text="${singlePerson.name}"表示访问model中singlePerson的name属性，
 th:if="${not #lists.isEmpty(people)}"表示判断model中的people集合是否为空，th:each="person:${people}"表示遍历people中的元素，
 这个和Java里的foreach差不多，person表示迭代元素。th:onclick="'getName(\''+${person.name}+'\');'"表示添加点击事件，点击事件由JavaScript来处理。
 th:inline="javascript"这样添加到的script标签可以通过[[${singlePerson}]]访问model中的属性
 
 