-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ms_admin`
--

DROP TABLE IF EXISTS `ms_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_admin`
--

LOCK TABLES `ms_admin` WRITE;
/*!40000 ALTER TABLE `ms_admin` DISABLE KEYS */;
INSERT INTO `ms_admin` VALUES (1,'admin','$2a$10$3cFb9q1JPRApzGBaLuVoV.jd0WgCBV9dChEA4j8RMvIHlUbBtNdC2'),(2,'mszlu','$2a$10$iBFPJIOXn8Qpmr6OzIMlg.KsHO2/veGw/n6jOaxBfe550HaLthsA.');
/*!40000 ALTER TABLE `ms_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_admin_permission`
--

DROP TABLE IF EXISTS `ms_admin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_admin_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin_id` bigint NOT NULL,
  `permission_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_admin_permission`
--

LOCK TABLES `ms_admin_permission` WRITE;
/*!40000 ALTER TABLE `ms_admin_permission` DISABLE KEYS */;
INSERT INTO `ms_admin_permission` VALUES (1,1,1),(2,2,1);
/*!40000 ALTER TABLE `ms_admin_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_article`
--

DROP TABLE IF EXISTS `ms_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_article` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment_counts` int DEFAULT NULL COMMENT '璇勮鏁伴噺',
  `create_date` bigint DEFAULT NULL COMMENT '鍒涘缓鏃堕棿',
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '绠€浠?,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鏍囬',
  `view_counts` int DEFAULT NULL COMMENT '娴忚鏁伴噺',
  `weight` int NOT NULL COMMENT '鏄惁缃《',
  `author_id` bigint DEFAULT NULL COMMENT '浣滆€卛d',
  `body_id` bigint DEFAULT NULL COMMENT '鍐呭id',
  `category_id` int DEFAULT NULL COMMENT '绫诲埆id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1653665697214971906 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_article`
--

LOCK TABLES `ms_article` WRITE;
/*!40000 ALTER TABLE `ms_article` DISABLE KEYS */;
INSERT INTO `ms_article` VALUES (1,12,1621947720727,'閫氳繃Spring Boot瀹炵幇鐨勬湇鍔★紝鍙渶瑕佷緷闈犱竴涓狫ava绫伙紝鎶婂畠鎵撳寘鎴恓ar锛屽苟閫氳繃`java -jar`鍛戒护灏卞彲浠ヨ繍琛岃捣鏉ャ€俓r\n\r\n杩欎竴鍒囩浉杈冧簬浼犵粺Spring搴旂敤鏉ヨ锛屽凡缁忓彉寰楅潪甯哥殑杞讳究銆佺畝鍗曘€?,'springboot浠嬬粛浠ュ強鍏ラ棬妗堜緥',163,0,1,1,2),(9,0,1613947720727,'Vue (璇婚煶 /vju藧/锛岀被浼间簬 view) 鏄竴濂楃敤浜庢瀯寤虹敤鎴风晫闈㈢殑娓愯繘寮忔鏋躲€?,'Vue.js 鍒板簳鏄粈涔?,28,0,1,20,2),(10,0,1523947720727,'鏈妭灏嗕粙缁嶅浣曞湪椤圭洰涓娇鐢?Element銆?,'Element鐩稿叧',19,0,1404448463944462338,21,2),(1648559034279591937,0,1681882077171,'12','title',13,0,1404448588146392386,1648559034279591938,1),(1648559336860876802,0,1681882149320,'娴嬭瘯鐨勬憳瑕?,'鎴戝幓锛屾祴璇曟爣棰?,12,0,1648246717931270145,1648559336860876803,2),(1648568348822097922,0,1681884297914,'12','title',5,0,1404448588146392386,1648568349291859970,1),(1648571220905373698,0,1681884982670,'鎽樿111','娴嬭瘯鏍囬锛氾細锛?,15,0,1648246717931270145,1648571221341581314,1),(1650049009814827009,0,1682237315022,'1','32323',13,0,1404448588146392386,1650049009814827010,1),(1650423232647311362,0,1682326536698,'my live','鐢熸椿鐨勬枃绔?,14,0,1404448588146392386,1650423232647311363,3),(1653665697214971905,0,1683099600493,'娴嬭瘯鐨勬憳瑕?,'鎴戝幓锛屾祴璇曟爣棰?,1,0,1648246717931270145,1653665697214971906,2);
/*!40000 ALTER TABLE `ms_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_article_body`
--

DROP TABLE IF EXISTS `ms_article_body`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_article_body` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `content_html` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  `article_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `article_id` (`article_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1653665697214971907 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_article_body`
--

LOCK TABLES `ms_article_body` WRITE;
/*!40000 ALTER TABLE `ms_article_body` DISABLE KEYS */;
INSERT INTO `ms_article_body` VALUES (1,'# 1. Spring Boot浠嬬粛\r\n\r\n## 1.1 绠€浠媆r\n\r\n鍦ㄦ偍绗?娆℃帴瑙﹀拰瀛︿範Spring妗嗘灦鐨勬椂鍊欙紝鏄惁鍥犱负鍏剁箒鏉傜殑閰嶇疆鑰岄€€鍗翠簡锛焅r\n\r\n鍦ㄤ綘绗琻娆′娇鐢⊿pring妗嗘灦鐨勬椂鍊欙紝鏄惁瑙夊緱涓€鍫嗗弽澶嶉粡璐寸殑閰嶇疆鏈変竴浜涘帉鐑︼紵\r\n\r\n閭ｄ箞鎮ㄥ氨涓嶅Θ鏉ヨ瘯璇曚娇鐢⊿pring Boot鏉ヨ浣犳洿鏄撲笂鎵嬶紝鏇寸畝鍗曞揩鎹峰湴鏋勫缓Spring搴旂敤锛乗r\n\r\nSpring Boot璁╂垜浠殑Spring搴旂敤鍙樼殑鏇磋交閲忓寲銆俓r\n\r\n鎴戜滑涓嶅繀鍍忎互鍓嶉偅鏍风箒鐞愮殑鏋勫缓椤圭洰銆佹墦鍖呭簲鐢ㄣ€侀儴缃插埌Tomcat绛夊簲鐢ㄦ湇鍔″櫒涓潵杩愯鎴戜滑鐨勪笟鍔℃湇鍔°€俓r\n\r\n閫氳繃Spring Boot瀹炵幇鐨勬湇鍔★紝鍙渶瑕佷緷闈犱竴涓狫ava绫伙紝鎶婂畠鎵撳寘鎴恓ar锛屽苟閫氳繃`java -jar`鍛戒护灏卞彲浠ヨ繍琛岃捣鏉ャ€俓r\n\r\n杩欎竴鍒囩浉杈冧簬浼犵粺Spring搴旂敤鏉ヨ锛屽凡缁忓彉寰楅潪甯哥殑杞讳究銆佺畝鍗曘€俓r\n\r\n**鎬荤粨涓€涓婼pring Boot鐨勪富瑕佷紭鐐癸細**\r\n\r\n1. 涓烘墍鏈塖pring寮€鍙戣€呮洿蹇殑鍏ラ棬\r\n2. 寮€绠卞嵆鐢紝鎻愪緵鍚勭榛樿閰嶇疆鏉ョ畝鍖栭」鐩厤缃甛r\n3. 鍐呭祵寮忓鍣ㄧ畝鍖朩eb椤圭洰\r\n4. 娌℃湁鍐椾綑浠ｇ爜鐢熸垚鍜孹ML閰嶇疆鐨勮姹俓r\n5. 缁熶竴鐨勪緷璧栫鐞哱r\n6. 鑷姩瑁呴厤锛屾洿鏄撲娇鐢紝鏇存槗鎵╁睍\r\n\r\n## 1.2 浣跨敤鐗堟湰璇存槑\r\n\r\nSpringboot鐗堟湰锛氫娇鐢ㄦ渶鏂扮殑2.5.0鐗堟湰\r\n\r\n鏁欑▼鍙傝€冧簡瀹樻柟鏂囨。杩涜鍒朵綔锛屾潈濞併€俓r\n\r\n鍏朵粬渚濊禆鐗堟湰锛歕r\n\r\n	1. Maven  闇€姹傦細3.5+\r\n\r\n   	2. JDK 闇€姹? 8+\r\n   	3. Spring Framework 5.3.7浠ヤ笂鐗堟湰\r\n   	4. Tomcat 9.0\r\n   	5. Servlet鐗堟湰 4.0  浣嗘槸鍙互閮ㄧ讲鍒癝ervlet鍒?.1+鐨勫鍣ㄤ腑\r\n\r\n# 2. 蹇€熷叆闂╘r\n\r\n蹇€熺殑鍒涘缓涓€涓猄pring Boot搴旂敤锛屽苟涓斿疄鐜颁竴涓畝鍗曠殑Http璇锋眰澶勭悊銆傞€氳繃杩欎釜渚嬪瓙瀵筍pring Boot鏈変竴涓垵姝ョ殑浜嗚В锛屽苟浣撻獙鍏剁粨鏋勭畝鍗曘€佸紑鍙戝揩閫熺殑鐗规€с€俓r\n\r\n鏁欑▼浣跨敤鐨処dea鐗堟湰锛?019.3\r\n\r\n## 2.1 鍒涘缓鍩虹椤圭洰\r\n\r\n**绗竴姝ワ細** 鍒涘缓maven椤圭洰\r\n\r\npom.xml :\r\n\r\n~~~xml\r\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\"\r\n         xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\r\n    <modelVersion>4.0.0</modelVersion>\r\n\r\n    <groupId>com.xiaopizhu</groupId>\r\n    <artifactId>helloSpringBoot</artifactId>\r\n    <version>1.0-SNAPSHOT</version>\r\n	<!--springboot鐨勭埗宸ョ▼鍏朵腑瀹氫箟浜嗗父鐢ㄧ殑渚濊禆锛屽苟涓旀棤渚濊禆鍐茬獊-->\r\n    <parent>\r\n        <groupId>org.springframework.boot</groupId>\r\n        <artifactId>spring-boot-starter-parent</artifactId>\r\n        <version>2.5.0</version>\r\n    </parent>\r\n</project>\r\n~~~\r\n\r\n娉ㄦ剰涓婃柟鐨刾arent蹇呴』鍔狅紝鍏朵腑瀹氫箟浜唖pringboot瀹樻柟鏀寔鐨刵澶氫緷璧栵紝鍩烘湰涓婂父鐢ㄧ殑宸茬粡鏈変簡锛屾墍浠ユ帴涓嬫潵瀵煎叆渚濊禆鐨勬椂鍊欙紝缁濆ぇ閮ㄥ垎閮藉彲浠ヤ笉鍔犵増鏈彿銆俓r\n\r\n姝ゆ椂鐨勫伐绋嬬粨鏋勪负锛歕r\n\r\n![image-20210523173241557](img/image-20210523173241557.png)\r\n\r\n**绗簩姝ワ細** 娣诲姞web渚濊禆\r\n\r\n~~~xml\r\n<dependencies>\r\n    <dependency>\r\n        <groupId>org.springframework.boot</groupId>\r\n        <artifactId>spring-boot-starter-web</artifactId>\r\n    </dependency>\r\n</dependencies>\r\n~~~\r\n\r\n娣诲姞涓婃柟鐨剋eb渚濊禆锛屽叾涓棿鎺ヤ緷璧栦簡spring-web锛宻pring-webmvc锛宻pring-core绛塻pring鍜宻pringmvc鐨勫寘锛屽苟涓旈泦鎴愪簡tomcat銆俓r\n\r\n**绗笁姝ワ細** 缂栧啓鍚姩绫籠r\n\r\n~~~java\r\npackage com.xiaopizhu.springboot;\r\n\r\nimport org.springframework.boot.SpringApplication;\r\nimport org.springframework.boot.autoconfigure.SpringBootApplication;\r\n\r\n@SpringBootApplication\r\npublic class HelloApp {\r\n\r\n    public static void main(String[] args) {\r\n        SpringApplication.run(HelloApp.class,args);\r\n    }\r\n}\r\n\r\n~~~\r\n\r\n@SpringBootApplication娉ㄨВ鏍囪瘑浜咹elloApp涓哄惎鍔ㄧ被锛屼篃鏄疭pring Boot鐨勬牳蹇冦€俓r\n\r\n**绗洓姝ワ細** 杩愯鍚姩绫荤殑main鏂规硶\r\n\r\n![image-20210523173712142](img/image-20210523173712142.png)\r\n\r\n鐪嬪埌濡備笂閰嶇疆锛岃瘉鏄庡惎鍔ㄦ垚鍔燂紝tomcat绔彛鍙烽粯璁や负8080銆俓r\n\r\n**绗簲姝ワ細**  濡傛灉鎯宠淇敼绔彛鍙凤紝鍙互鍦╮esources鐩綍涓嬫柊寤篴pplication.properties\r\n\r\n~~~properties\r\nserver.port=8082\r\n~~~\r\n\r\n**绗叚姝ワ細** 閲嶆柊杩愯\r\n\r\n![image-20210523174011613](img/image-20210523174011613.png)\r\n\r\n姝ゆ椂鐨勯」鐩粨鏋勪负锛歕r\n\r\n![image-20210523174032053](img/image-20210523174032053.png)\r\n\r\n**src/main/java :**  缂栧啓java浠ｇ爜锛屾敞鎰忓惎鍔ㄧ被闇€瑕佹斁鍦ㄩ」鐩殑鏍瑰寘涓嬨€俓r\n\r\n**src/main/resources:**  鏀剧疆璧勬簮鐨勭洰褰曪紝姣斿springboot鐨勯厤缃枃浠讹紝闈欐€佹枃浠讹紝mybatis閰嶇疆锛屾棩蹇楅厤缃瓑銆俓r\n\r\n**src/test/java:**  娴嬭瘯浠ｇ爜\r\n\r\n## 2.2 缂栧啓涓€涓狧ttp鎺ュ彛\r\n\r\n**绗竴姝ワ細**鍒涘缓`HelloController`绫伙紝鍐呭濡備笅锛歕r\n\r\n~~~java\r\npackage com.xiaopizhu.springboot.controller;\r\n\r\nimport org.springframework.web.bind.annotation.GetMapping;\r\nimport org.springframework.web.bind.annotation.RequestMapping;\r\nimport org.springframework.web.bind.annotation.RestController;\r\n\r\n@RestController\r\n@RequestMapping(\"hello\")\r\npublic class HelloController {\r\n\r\n    @GetMapping(\"boot\")\r\n    public String hello(){\r\n        return \"hello spring boot\";\r\n    }\r\n\r\n}\r\n\r\n~~~\r\n\r\n**娉ㄦ剰鍖呭悕锛屽繀椤诲湪鍚姩绫绘墍鍦ㄧ殑鍖呭悕涓嬨€?*\r\n\r\n**绗簩姝ワ細**閲嶅惎绋嬪簭锛屼娇鐢╬ostman鎴栬€呯洿鎺ュ湪娴忚鍣ㄨ緭鍏ttp://localhost:8082/hello/boot\r\n\r\n寰楀埌缁撴灉锛歨ello spring boot\r\n\r\n## 2.3 缂栧啓鍗曞厓娴嬭瘯鐢ㄤ緥\r\n\r\n**绗竴姝ワ細**娣诲姞spring boot娴嬭瘯渚濊禆\r\n\r\n~~~xml\r\n		<dependency>\r\n            <groupId>org.springframework.boot</groupId>\r\n            <artifactId>spring-boot-starter-test</artifactId>\r\n            <scope>test</scope>\r\n        </dependency>\r\n~~~\r\n\r\n**绗簩姝ワ細**鍦╯rc/test 涓嬶紝缂栧啓娴嬭瘯鐢ㄤ緥\r\n\r\n~~~java\r\npackage com.xiaopizhu.springboot.controller;\r\n\r\nimport org.junit.jupiter.api.BeforeAll;\r\nimport org.junit.jupiter.api.BeforeEach;\r\nimport org.junit.jupiter.api.Test;\r\nimport org.springframework.boot.test.context.SpringBootTest;\r\nimport org.springframework.http.MediaType;\r\nimport org.springframework.test.web.servlet.MockMvc;\r\nimport org.springframework.test.web.servlet.request.MockMvcRequestBuilders;\r\nimport org.springframework.test.web.servlet.setup.MockMvcBuilders;\r\n\r\nimport static org.hamcrest.Matchers.equalTo;\r\nimport static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;\r\nimport static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;\r\n\r\n@SpringBootTest\r\npublic class TestHelloController {\r\n\r\n    private MockMvc mockMvc;\r\n\r\n    @BeforeEach\r\n    public void beforeEach(){\r\n        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();\r\n    }\r\n    @Test\r\n    public void testHello() throws Exception {\r\n        mockMvc.perform(MockMvcRequestBuilders.get(\"/hello/boot\")\r\n                .accept(MediaType.APPLICATION_JSON))\r\n                .andExpect(status().isOk())\r\n                .andExpect(content().string(equalTo(\"hello spring boot\")));\r\n    }\r\n}\r\n\r\n~~~\r\n\r\n涓婇潰鐨勬祴璇曠敤渚嬶紝鏄瀯寤轰竴涓┖鐨刞WebApplicationContext`锛屽苟涓斿湪before涓姞杞戒簡HelloController锛屽緱浠ュ湪娴嬭瘯鐢ㄤ緥涓璵ock璋冪敤锛屾ā鎷熻姹傘€俓r\n\r\n## 2.4 鎵撳寘涓簀ar杩愯\r\n\r\n**绗竴姝ワ細**娣诲姞鎵撳寘(maven鏋勫缓springboot)鎻掍欢\r\n\r\n~~~xml\r\n  <build>\r\n        <plugins>\r\n            <plugin>\r\n                <groupId>org.springframework.boot</groupId>\r\n                <artifactId>spring-boot-maven-plugin</artifactId>\r\n            </plugin>\r\n        </plugins>\r\n    </build>\r\n~~~\r\n\r\n鍦╥dea鐨勫彸渚?maven涓紝浣跨敤package鏉ユ墦鍖呯▼搴忥紝鎵撳寘瀹屾垚鍚庯紝鍦╰arget鐩綍涓嬬敓鎴恏elloSpringBoot-1.0-SNAPSHOT.jar\r\n\r\n![image-20210523181737720](img/image-20210523181737720.png)\r\n\r\n**绗簩姝ワ細**鎵撳紑cmd锛氭壘鍒癹ar瀵瑰簲鐨勭洰褰昞r\n\r\n杈撳叆鍛戒护\r\n\r\n~~~shell\r\njava -jar helloSpringBoot-1.0-SNAPSHOT.jar\r\n~~~\r\n\r\n![image-20210523182426404](img/image-20210523182426404.png)\r\n\r\n**绗笁姝ワ細**娴嬭瘯锛屼娇鐢╬ostman鎴栬€呯洿鎺ュ湪娴忚鍣ㄨ緭鍏ttp://localhost:8082/hello/boot\r\n\r\n寰楀埌缁撴灉锛歨ello spring boot\r\n\r\n## 2.5 鏌ョ湅jar鍖呭唴瀹筡r\n\r\n~~~shell\r\njar tvf helloSpringBoot-1.0-SNAPSHOT.jar\r\n~~~\r\n\r\n# 3. 灏忕粨\r\n\r\n1. 閫氳繃Maven鏋勫缓浜嗕竴涓┖鐧絊pring Boot椤圭洰锛屽啀閫氳繃寮曞叆web妯″潡瀹炵幇浜嗕竴涓畝鍗曠殑璇锋眰澶勭悊銆俓r\n2. 閫氳繃淇敼閰嶇疆鏂囦欢锛屾洿鏀圭鍙ｅ彿\r\n3. 缂栧啓浜嗘祴璇曠敤渚媆r\n4. 鎵撳寘jar鍖呰繍琛孿r\n\r\n','<h2>2018-01-04</h2>\n<pre><code class=\"lang-\"># 浣跨敤vue鐨刉ebpack妯℃澘鐢熸垚鑴氭墜鏋禱n</code></pre>\n<h2>2018-01-05</h2>\n<pre><code class=\"lang-\"># 寮曞叆ElementUI\n\n# babel-plugin-component鑷畾涔変富棰榎n# 棣栭〉\n# 鐧婚檰椤礬n# 娉ㄥ唽椤甸潰\n# 鏃ュ織椤礬n</code></pre>\n<h2>2018-01-07</h2>\n<pre><code class=\"lang-\"># 璋冩暣搴曢儴鏍忓缁堝浐瀹氬湪搴曢儴\n# 鏃ュ織椤?娣诲姞鏃堕棿杞碶n# 棣栭〉鐨勬枃绔犲垪琛╘n</code></pre>\n<h2>2018-01-08</h2>\n<pre><code class=\"lang-\"># 浣跨敤缁勪欢-鍗氬浣滆€卼ab椤?\n# 娣诲姞绗笁鏂瑰浘鏍嘰n</code></pre>\n<h2>2018-01-09</h2>\n<pre><code class=\"lang-\"># 璋冩暣椤堕儴瀵艰埅鏍忥細婵€娲绘枃瀛楅鑹诧紝click鐐瑰嚮\n# 缁勪欢-鏈€鏂版枃绔爐ab椤礬n\n# 鏈€鏂版枃绔犮€佹渶鐑枃绔犱娇鐢ㄧ浉鍚岀粍浠禱n# 搴曢儴鏍忚璁n# 椤甸潰涓庝袱杈硅竟璺濇敼涓?00\n</code></pre>\n<h2>2018-01-10</h2>\n<pre><code class=\"lang-\"># 鍐欏崥瀹?寮曞叆mavonEditor缂栬緫鍣╘n# 椤堕儴瀵艰埅鏍忛兘鏀惧叆涓€涓狹enu涓璡n# 鍐欐枃绔犻〉闈n#銆€mavonEditor灞€閮ㄥ紩鍏n\n#銆€椤甸潰鐨勪腑闂村尯鍩熷浐瀹氬搴︼紝鑷姩灞呬腑\n# 鍙戝竷鍜屽彇娑圽n# 鍙戝竷dialog\n\n</code></pre>\n<h2>2018-01-11</h2>\n<pre><code class=\"lang-\"># 鏂囩珷缁勪欢鐢ㄥ畧鍗潵鏀瑰彉body鑳屾櫙鑹瞈n# 璋冩暣鐧婚檰鍜屾敞鍐岄〉闈紝浣垮叾灞呬腑\n\n#瀛愰〉闈㈣皟鏁存牴鍏冪礌涓篸iv\n#鏂囩珷璇︽儏椤礬n\n</code></pre>\n<h2>2018-01-12</h2>\n<pre><code class=\"lang-\"># 鏂囩珷璇︽儏椤? 鍐呭  璇勮绛塡n\n</code></pre>\n<h2>2018-01-13</h2>\n<pre><code class=\"lang-\">## 閲嶆柊璋冩暣椤甸潰缁撴瀯	\n#椤堕儴鍜屽簳閮?鎶芥垚  BaseHeader BaseFooter 缁勪欢\n#BlogView涓哄崟鐙〉锛屼互鍓嶆槸Home鐨勫瓙璺敱\n\n</code></pre>\n<h2>2018-01-15</h2>\n<pre><code class=\"lang-\"># 鏂囩珷鍒嗙被鍘绘帀瀛愮骇\n# 灏嗛椤电殑鏂囩珷鍒楄〃鎶芥垚 ArticleItem缁勪欢\n# 澧炲姞鏂囩珷鐨勮瘎璁哄睍绀篭n# 澧炲姞鏂囩珷鍒嗙被銆佹爣绛鹃〉\n\n</code></pre>\n<h2>2018-01-15  2</h2>\n<pre><code class=\"lang-\"># 鍥炲埌椤堕儴鍘绘帀杩囨浮鍔ㄧ敾锛堝奖鍝嶉《閮ㄥ鑸爮锛塡n# 椤堕儴瀵艰埅鏍?澧炲姞鐧诲綍鍚庤彍鍗昞n# 棣栭〉澧炲姞 鏈€鐑爣绛綷n# 澧炲姞 鏂囩珷鍒嗙被 鏍囩鐨勮鎯呴〉\n# 灏嗘枃绔犺鎯呴〉銆?鏂囩珷鍒嗙被鏍囩椤?鏀逛负Home鐨勫瓙璺敱锛堜互鍓嶅崟鐙〉锛塡n# Home缁勪欢澧炲姞璺敱鍒ゆ柇锛氭洿姝ｅ鑸爮鐨勭姸鎬併€佹潯浠舵樉绀哄簳閮ㄦ爮\n\n</code></pre>\n<h2>2018-01-16</h2>\n<pre><code class=\"lang-\"># 灏嗗啓鏂囩珷鐨勯《閮℉eader鍚堝苟鍒癇aseHeader涓璡n# 鍥剧墖閮芥斁鍒颁簡static鐩綍涓媆n\n</code></pre>\n<h2>2018-01-24</h2>\n<pre><code class=\"lang-\"># 灏嗚嚜瀹氫箟鐨則heme鏀惧埌assets涓媆n# 鍔犲叆axios\n# 鍔犲叆vuex\n# 瀹炵幇鐧诲綍\n# 瀹炵幇閫€鍑篭n\n</code></pre>\n<h2>2018-01-25</h2>\n<pre><code class=\"lang-\"># 瀹炵幇娉ㄥ唽閫昏緫\n# 鍐欐枃绔犲姛鑳藉疄鐜癨n# 鍐欐枃绔犳椂鏀寔鎻掑叆鍥剧墖\n\n</code></pre>\n<h2>2018-01-26</h2>\n<pre><code class=\"lang-\"># 寮曞叆lodash宸ュ叿绫籠n# 浼樺寲鍐欐枃绔犵殑宸ュ叿鏍忥細婊氬姩鏃跺浐瀹氶《閮╘n# 鍐欐枃绔?鍚庡彴鑾峰彇鏂囩珷鍒嗙被鍜屾爣绛綷n\n# 棣栭〉鐨勬枃绔犲垪琛╘n\n</code></pre>\n<h2>2018-01-27</h2>\n<pre><code class=\"lang-\"># 淇敼棣栭〉鏂囩珷鍒楄〃鐨勬牱寮廫n# 棣栭〉鍔犺浇鏂囩珷鍔熻兘\n# 鏂囩珷鏌ョ湅鍔熻兘\n# 鏂囩珷鍒嗙被鍜屾爣绛惧姛鑳藉垪琛╘n\n</code></pre>\n<h2>2018-01-28</h2>\n<pre><code class=\"lang-\"># 鏂囩珷鍒嗙被鍜屾爣绛捐鎯匼n\n</code></pre>\n<h2>2018-01-29</h2>\n<pre><code class=\"lang-\"># 鏂囩珷鍒嗙被鍜屾爣绛剧殑鏂囩珷鏁癨n# 棣栭〉鏈€鐑枃绔燶n# 棣栭〉鏈€鏂版枃绔燶n# 棣栭〉鏈€鐑爣绛綷n\n</code></pre>\n<h2>2018-01-30</h2>\n<pre><code class=\"lang-\"># BaseHeader鏀惧洖views涓璡n# 淇敼Axios鍚庣疆鎷︽埅锛屽叏灞€澶勭悊閿欒\n# 灏嗙櫥褰?閫€鍑?鍜屽ご鍍?鏀惧埌涓€璧穃n\n</code></pre>\n',1),(20,'Vue (璇婚煶 /vju藧/锛岀被浼间簬 view) 鏄竴濂楃敤浜庢瀯寤虹敤鎴风晫闈㈢殑娓愯繘寮忔鏋躲€備笌鍏跺畠澶у瀷妗嗘灦涓嶅悓鐨勬槸锛孷ue 琚璁′负鍙互鑷簳鍚戜笂閫愬眰搴旂敤銆俈ue 鐨勬牳蹇冨簱鍙叧娉ㄨ鍥惧眰锛屼笉浠呮槗浜庝笂鎵嬶紝杩樹究浜庝笌绗笁鏂瑰簱鎴栨棦鏈夐」鐩暣鍚堛€傚彟涓€鏂归潰锛屽綋涓庣幇浠ｅ寲鐨勫伐鍏烽摼浠ュ強鍚勭鏀寔绫诲簱缁撳悎浣跨敤鏃讹紝Vue 涔熷畬鍏ㄨ兘澶熶负澶嶆潅鐨勫崟椤靛簲鐢ㄦ彁渚涢┍鍔ㄣ€俓n\n濡傛灉浣犳兂鍦ㄦ繁鍏ュ涔?Vue 涔嬪墠瀵瑰畠鏈夋洿澶氫簡瑙ｏ紝鎴戜滑鍒朵綔浜嗕竴涓棰戯紝甯︽偍浜嗚В鍏舵牳蹇冩蹇靛拰涓€涓ず渚嬪伐绋嬨€俓n濡傛灉浣犲凡缁忔槸鏈夌粡楠岀殑鍓嶇寮€鍙戣€咃紝鎯崇煡閬?Vue 涓庡叾瀹冨簱/妗嗘灦鏈夊摢浜涘尯鍒紝璇锋煡鐪嬪姣斿叾瀹冩鏋躲€俓n\n# 璧锋\n\n> 瀹樻柟鎸囧崡鍋囪浣犲凡浜嗚В鍏充簬 HTML銆丆SS 鍜?JavaScript 鐨勪腑绾х煡璇嗐€傚鏋滀綘鍒氬紑濮嬪涔犲墠绔紑鍙戯紝灏嗘鏋朵綔涓轰綘鐨勭涓€姝ュ彲鑳戒笉鏄渶濂界殑涓绘剰鈥斺€旀帉鎻″ソ鍩虹鐭ヨ瘑鍐嶆潵鍚э紒涔嬪墠鏈夊叾瀹冩鏋剁殑浣跨敤缁忛獙浼氭湁甯姪锛屼絾杩欎笉鏄繀闇€鐨勩€俓n\n灏濊瘯 Vue.js 鏈€绠€鍗曠殑鏂规硶鏄娇鐢?JSFiddle 涓婄殑 Hello World 渚嬪瓙銆備綘鍙互鍦ㄦ祻瑙堝櫒鏂版爣绛鹃〉涓墦寮€瀹冿紝璺熺潃渚嬪瓙瀛︿範涓€浜涘熀纭€鐢ㄦ硶銆傛垨鑰呬綘涔熷彲浠ュ垱寤轰竴涓?.html 鏂囦欢锛岀劧鍚庨€氳繃濡備笅鏂瑰紡寮曞叆 Vue锛歕n\n```javascript\n<script src=\"https://cdn.jsdelivr.net/npm/vue\"></script>\n\n```\n瀹夎鏁欑▼缁欏嚭浜嗘洿澶氬畨瑁?Vue 鐨勬柟寮忋€傝娉ㄦ剰鎴戜滑涓嶆帹鑽愭柊鎵嬬洿鎺ヤ娇鐢?vue-cli锛屽挨鍏舵槸鍦ㄤ綘杩樹笉鐔熸倝鍩轰簬 Node.js 鐨勬瀯寤哄伐鍏锋椂銆俓n\n# 澹版槑寮忔覆鏌揬nVue.js 鐨勬牳蹇冩槸涓€涓厑璁搁噰鐢ㄧ畝娲佺殑妯℃澘璇硶鏉ュ０鏄庡紡鍦板皢鏁版嵁娓叉煋杩?DOM 鐨勭郴缁燂細\n```javascript\n<div id=\"app\">\n  {{ message }}\n</div>\n\n```\n```javascript\nvar app = new Vue({\n  el: \'#app\',\n  data: {\n    message: \'Hello Vue!\'\n  }\n})\n\n```\n鎴戜滑宸茬粡鎴愬姛鍒涘缓浜嗙涓€涓?Vue 搴旂敤锛佺湅璧锋潵杩欒窡娓叉煋涓€涓瓧绗︿覆妯℃澘闈炲父绫讳技锛屼絾鏄?Vue 鍦ㄨ儗鍚庡仛浜嗗ぇ閲忓伐浣溿€傜幇鍦ㄦ暟鎹拰 DOM 宸茬粡琚缓绔嬩簡鍏宠仈锛屾墍鏈変笢瑗块兘鏄搷搴斿紡鐨勩€傛垜浠鎬庝箞纭鍛紵鎵撳紑浣犵殑娴忚鍣ㄧ殑 JavaScript 鎺у埗鍙?(灏卞湪杩欎釜椤甸潰鎵撳紑)锛屽苟淇敼 app.message 鐨勫€硷紝浣犲皢鐪嬪埌涓婁緥鐩稿簲鍦版洿鏂般€俓n\n闄や簡鏂囨湰鎻掑€硷紝鎴戜滑杩樺彲浠ュ儚杩欐牱鏉ョ粦瀹氬厓绱犵壒鎬э細\n\n\n\n\n\n\n','<p>Vue (璇婚煶 /vju藧/锛岀被浼间簬 view) 鏄竴濂楃敤浜庢瀯寤虹敤鎴风晫闈㈢殑娓愯繘寮忔鏋躲€備笌鍏跺畠澶у瀷妗嗘灦涓嶅悓鐨勬槸锛孷ue 琚璁′负鍙互鑷簳鍚戜笂閫愬眰搴旂敤銆俈ue 鐨勬牳蹇冨簱鍙叧娉ㄨ鍥惧眰锛屼笉浠呮槗浜庝笂鎵嬶紝杩樹究浜庝笌绗笁鏂瑰簱鎴栨棦鏈夐」鐩暣鍚堛€傚彟涓€鏂归潰锛屽綋涓庣幇浠ｅ寲鐨勫伐鍏烽摼浠ュ強鍚勭鏀寔绫诲簱缁撳悎浣跨敤鏃讹紝Vue 涔熷畬鍏ㄨ兘澶熶负澶嶆潅鐨勫崟椤靛簲鐢ㄦ彁渚涢┍鍔ㄣ€?/p>\n<p>濡傛灉浣犳兂鍦ㄦ繁鍏ュ涔?Vue 涔嬪墠瀵瑰畠鏈夋洿澶氫簡瑙ｏ紝鎴戜滑鍒朵綔浜嗕竴涓棰戯紝甯︽偍浜嗚В鍏舵牳蹇冩蹇靛拰涓€涓ず渚嬪伐绋嬨€?br />\n濡傛灉浣犲凡缁忔槸鏈夌粡楠岀殑鍓嶇寮€鍙戣€咃紝鎯崇煡閬?Vue 涓庡叾瀹冨簱/妗嗘灦鏈夊摢浜涘尯鍒紝璇锋煡鐪嬪姣斿叾瀹冩鏋躲€?/p>\n<h1>璧锋</h1>\n<blockquote>\n<p>瀹樻柟鎸囧崡鍋囪浣犲凡浜嗚В鍏充簬 HTML銆丆SS 鍜?JavaScript 鐨勪腑绾х煡璇嗐€傚鏋滀綘鍒氬紑濮嬪涔犲墠绔紑鍙戯紝灏嗘鏋朵綔涓轰綘鐨勭涓€姝ュ彲鑳戒笉鏄渶濂界殑涓绘剰鈥斺€旀帉鎻″ソ鍩虹鐭ヨ瘑鍐嶆潵鍚э紒涔嬪墠鏈夊叾瀹冩鏋剁殑浣跨敤缁忛獙浼氭湁甯姪锛屼絾杩欎笉鏄繀闇€鐨勩€?/p>\n</blockquote>\n<p>灏濊瘯 Vue.js 鏈€绠€鍗曠殑鏂规硶鏄娇鐢?JSFiddle 涓婄殑 Hello World 渚嬪瓙銆備綘鍙互鍦ㄦ祻瑙堝櫒鏂版爣绛鹃〉涓墦寮€瀹冿紝璺熺潃渚嬪瓙瀛︿範涓€浜涘熀纭€鐢ㄦ硶銆傛垨鑰呬綘涔熷彲浠ュ垱寤轰竴涓?.html 鏂囦欢锛岀劧鍚庨€氳繃濡備笅鏂瑰紡寮曞叆 Vue锛?/p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">&lt;script src=<span class=\"hljs-string\">\"https://cdn.jsdelivr.net/npm/vue\"</span>&gt;<span class=\"xml\"><span class=\"hljs-tag\">&lt;/<span class=\"hljs-name\">script</span>&gt;</span></span>\n\n</code></div></pre>\n<p>瀹夎鏁欑▼缁欏嚭浜嗘洿澶氬畨瑁?Vue 鐨勬柟寮忋€傝娉ㄦ剰鎴戜滑涓嶆帹鑽愭柊鎵嬬洿鎺ヤ娇鐢?vue-cli锛屽挨鍏舵槸鍦ㄤ綘杩樹笉鐔熸倝鍩轰簬 Node.js 鐨勬瀯寤哄伐鍏锋椂銆?/p>\n<h1>澹版槑寮忔覆鏌?/h1>\n<p>Vue.js 鐨勬牳蹇冩槸涓€涓厑璁搁噰鐢ㄧ畝娲佺殑妯℃澘璇硶鏉ュ０鏄庡紡鍦板皢鏁版嵁娓叉煋杩?DOM 鐨勭郴缁燂細</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\">&lt;div id=<span class=\"hljs-string\">\"app\"</span>&gt;\n  {{ message }}\n&lt;<span class=\"hljs-regexp\">/div&gt;\n\n</span></code></div></pre>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">var</span> app = <span class=\"hljs-keyword\">new</span> Vue({\n  <span class=\"hljs-attr\">el</span>: <span class=\"hljs-string\">\'#app\'</span>,\n  <span class=\"hljs-attr\">data</span>: {\n    <span class=\"hljs-attr\">message</span>: <span class=\"hljs-string\">\'Hello Vue!\'</span>\n  }\n})\n\n</code></div></pre>\n<p>鎴戜滑宸茬粡鎴愬姛鍒涘缓浜嗙涓€涓?Vue 搴旂敤锛佺湅璧锋潵杩欒窡娓叉煋涓€涓瓧绗︿覆妯℃澘闈炲父绫讳技锛屼絾鏄?Vue 鍦ㄨ儗鍚庡仛浜嗗ぇ閲忓伐浣溿€傜幇鍦ㄦ暟鎹拰 DOM 宸茬粡琚缓绔嬩簡鍏宠仈锛屾墍鏈変笢瑗块兘鏄搷搴斿紡鐨勩€傛垜浠鎬庝箞纭鍛紵鎵撳紑浣犵殑娴忚鍣ㄧ殑 JavaScript 鎺у埗鍙?(灏卞湪杩欎釜椤甸潰鎵撳紑)锛屽苟淇敼 app.message 鐨勫€硷紝浣犲皢鐪嬪埌涓婁緥鐩稿簲鍦版洿鏂般€?/p>\n<p>闄や簡鏂囨湰鎻掑€硷紝鎴戜滑杩樺彲浠ュ儚杩欐牱鏉ョ粦瀹氬厓绱犵壒鎬э細</p>\n',9),(21,'## 蹇€熶笂鎵媆n\n鏈妭灏嗕粙缁嶅浣曞湪椤圭洰涓娇鐢?Element銆俓n\n### 浣跨敤 Starter Kit\n鎴戜滑鎻愪緵浜嗛€氱敤鐨勯」鐩ā鏉匡紝浣犲彲浠ョ洿鎺ヤ娇鐢ㄣ€傚浜?Laravel 鐢ㄦ埛锛屾垜浠篃鍑嗗浜嗙浉搴旂殑妯℃澘锛屽悓鏍峰彲浠ョ洿鎺ヤ笅杞戒娇鐢ㄣ€俓n\n濡傛灉涓嶅笇鏈涗娇鐢ㄦ垜浠彁渚涚殑妯℃澘锛岃缁х画闃呰銆俓n\n### 浣跨敤 vue-cli\n\n鎴戜滑杩樺彲浠ヤ娇鐢?vue-cli 鍒濆鍖栭」鐩紝鍛戒护濡備笅锛歕n\n```language\n> npm i -g vue-cli\n> mkdir my-project && cd my-project\n> vue init webpack\n> npm i && npm i element-ui\n```\n\n### 寮曞叆 Element\n浣犲彲浠ュ紩鍏ユ暣涓?Element锛屾垨鏄牴鎹渶瑕佷粎寮曞叆閮ㄥ垎缁勪欢銆傛垜浠厛浠嬬粛濡備綍寮曞叆瀹屾暣鐨?Element銆俓n\n#### 瀹屾暣寮曞叆\n鍦?main.js 涓啓鍏ヤ互涓嬪唴瀹癸細\n```javascript\nimport Vue from \'vue\'\nimport ElementUI from \'element-ui\'\nimport \'element-ui/lib/theme-chalk/index.css\'\nimport App from \'./App.vue\'\n\nVue.use(ElementUI)\n\nnew Vue({\n  el: \'#app\',\n  render: h => h(App)\n})\n\n```\n浠ヤ笂浠ｇ爜渚垮畬鎴愪簡 Element 鐨勫紩鍏ャ€傞渶瑕佹敞鎰忕殑鏄紝鏍峰紡鏂囦欢闇€瑕佸崟鐙紩鍏ャ€俓n\n#### 鎸夐渶寮曞叆\n鍊熷姪 babel-plugin-component锛屾垜浠彲浠ュ彧寮曞叆闇€瑕佺殑缁勪欢锛屼互杈惧埌鍑忓皬椤圭洰浣撶Н鐨勭洰鐨勩€俓n\n棣栧厛锛屽畨瑁?babel-plugin-component锛歕n\n','<h2>蹇€熶笂鎵?/h2>\n<p>鏈妭灏嗕粙缁嶅浣曞湪椤圭洰涓娇鐢?Element銆?/p>\n<h3>浣跨敤 Starter Kit</h3>\n<p>鎴戜滑鎻愪緵浜嗛€氱敤鐨勯」鐩ā鏉匡紝浣犲彲浠ョ洿鎺ヤ娇鐢ㄣ€傚浜?Laravel 鐢ㄦ埛锛屾垜浠篃鍑嗗浜嗙浉搴旂殑妯℃澘锛屽悓鏍峰彲浠ョ洿鎺ヤ笅杞戒娇鐢ㄣ€?/p>\n<p>濡傛灉涓嶅笇鏈涗娇鐢ㄦ垜浠彁渚涚殑妯℃澘锛岃缁х画闃呰銆?/p>\n<h3>浣跨敤 vue-cli</h3>\n<p>鎴戜滑杩樺彲浠ヤ娇鐢?vue-cli 鍒濆鍖栭」鐩紝鍛戒护濡備笅锛?/p>\n<pre><code class=\"lang-language\">&gt; npm i -g vue-cli\n&gt; mkdir my-project &amp;&amp; cd my-project\n&gt; vue init webpack\n&gt; npm i &amp;&amp; npm i element-ui\n</code></pre>\n<h3>寮曞叆 Element</h3>\n<p>浣犲彲浠ュ紩鍏ユ暣涓?Element锛屾垨鏄牴鎹渶瑕佷粎寮曞叆閮ㄥ垎缁勪欢銆傛垜浠厛浠嬬粛濡備綍寮曞叆瀹屾暣鐨?Element銆?/p>\n<h4>瀹屾暣寮曞叆</h4>\n<p>鍦?main.js 涓啓鍏ヤ互涓嬪唴瀹癸細</p>\n<pre><div class=\"hljs\"><code class=\"lang-javascript\"><span class=\"hljs-keyword\">import</span> Vue <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\'vue\'</span>\n<span class=\"hljs-keyword\">import</span> ElementUI <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\'element-ui\'</span>\n<span class=\"hljs-keyword\">import</span> <span class=\"hljs-string\">\'element-ui/lib/theme-chalk/index.css\'</span>\n<span class=\"hljs-keyword\">import</span> App <span class=\"hljs-keyword\">from</span> <span class=\"hljs-string\">\'./App.vue\'</span>\n\nVue.use(ElementUI)\n\n<span class=\"hljs-keyword\">new</span> Vue({\n  <span class=\"hljs-attr\">el</span>: <span class=\"hljs-string\">\'#app\'</span>,\n  <span class=\"hljs-attr\">render</span>: <span class=\"hljs-function\"><span class=\"hljs-params\">h</span> =&gt;</span> h(App)\n})\n\n</code></div></pre>\n<p>浠ヤ笂浠ｇ爜渚垮畬鎴愪簡 Element 鐨勫紩鍏ャ€傞渶瑕佹敞鎰忕殑鏄紝鏍峰紡鏂囦欢闇€瑕佸崟鐙紩鍏ャ€?/p>\n<h4>鎸夐渶寮曞叆</h4>\n<p>鍊熷姪 babel-plugin-component锛屾垜浠彲浠ュ彧寮曞叆闇€瑕佺殑缁勪欢锛屼互杈惧埌鍑忓皬椤圭洰浣撶Н鐨勭洰鐨勩€?/p>\n<p>棣栧厛锛屽畨瑁?babel-plugin-component锛?/p>\n',10),(1648559034279591938,'*content*','<p><em>content</em></p>\n',1648559034279591937),(1648559336860876803,'```java\npublic static void main(args a){\n	\n}\n```\n娴嬭瘯','<pre><div class=\"hljs\"><code class=\"lang-java\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">static</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">main</span><span class=\"hljs-params\">(args a)</span></span>{\n	\n}\n</code></div></pre>\n<p>娴嬭瘯</p>\n',1648559336860876802),(1648568349291859970,'*content*','<p><em>content</em></p>\n',1648568348822097922),(1648570085456957442,'# 浜戦鐨勬枃绔燶ncontent............................','<h1><a id=\"_0\"></a>浜戦鐨勬枃绔?/h1>\n<p>content鈥?/p>\n',1648570085389848578),(1648570124958912514,'# 浜戦鐨勬枃绔燶ncontent............................','<h1><a id=\"_0\"></a>浜戦鐨勬枃绔?/h1>\n<p>content鈥?/p>\n',1648570124958912513),(1648571047944867843,'## 浜岀骇鏍囬褰撴椂','<h2><a id=\"_0\"></a>浜岀骇鏍囬褰撴椂</h2>\n',1648571047944867842),(1648571221341581314,'## 浜岀骇鏍囬褰撴椂','<h2><a id=\"_0\"></a>浜岀骇鏍囬褰撴椂</h2>\n',1648571220905373698),(1650049009814827010,'韪╄俯韪?,'<p>韪╄俯韪?/p>\n',1650049009814827009),(1650423232647311363,'live, *my live*','<p>live, <em>my live</em></p>\n',1650423232647311362),(1653665697214971906,'```java\npublic static void main(args a){\n	\n}\n```\n娴嬭瘯\n鎴戞洿鏂颁簡~','<pre><div class=\"hljs\"><code class=\"lang-java\"><span class=\"hljs-function\"><span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">static</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">main</span><span class=\"hljs-params\">(args a)</span></span>{\n	\n}\n</code></div></pre>\n<p>娴嬭瘯<br />\n鎴戞洿鏂颁簡~</p>\n',1653665697214971905);
/*!40000 ALTER TABLE `ms_article_body` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_article_tag`
--

DROP TABLE IF EXISTS `ms_article_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_article_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `article_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `article_id` (`article_id`) USING BTREE,
  KEY `tag_id` (`tag_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1653665697214971908 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_article_tag`
--

LOCK TABLES `ms_article_tag` WRITE;
/*!40000 ALTER TABLE `ms_article_tag` DISABLE KEYS */;
INSERT INTO `ms_article_tag` VALUES (1,1,7),(2,1,5),(3,1,8),(4,9,7),(5,10,7),(6,10,8),(7,10,5),(8,10,6),(1405564731321802753,1405564731300831233,5),(1405909844761800706,1405909844724051969,5),(1405916999787233281,1405916999732707330,5),(1648559034279591939,1648559034279591937,5),(1648559034329923586,1648559034279591937,6),(1648559336860876804,1648559336860876802,5),(1648568349291859971,1648568348822097922,5),(1648568349350580226,1648568348822097922,6),(1648570085456957443,1648570085389848578,5),(1648570124958912515,1648570124958912513,5),(1648571047944867844,1648571047944867842,6),(1648571221408690177,1648571220905373698,6),(1648571221408690178,1648571220905373698,7),(1648571221408690179,1648571220905373698,5),(1648571221408690180,1648571220905373698,8),(1650049009814827011,1650049009814827009,5),(1650423232647311364,1650423232647311362,8),(1653665697214971907,1653665697214971905,8);
/*!40000 ALTER TABLE `ms_article_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_category`
--

DROP TABLE IF EXISTS `ms_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_category`
--

LOCK TABLES `ms_category` WRITE;
/*!40000 ALTER TABLE `ms_category` DISABLE KEYS */;
INSERT INTO `ms_category` VALUES (1,'/static/category/front.png','鍓嶇','鍓嶇鏄粈涔堬紝澶у墠绔?),(2,'/static/category/back.png','鍚庣','鍚庣鏈€鐗涘弶'),(3,'/static/category/lift.jpg','鐢熸椿','鐢熸椿瓒ｄ簨'),(4,'/static/category/database.png','鏁版嵁搴?,'娌℃暟鎹簱锛屽暐涔熶笉绠＄敤'),(5,'/static/category/language.png','缂栫▼璇█','濂藉璇█锛岃瀛﹀摢涓紵');
/*!40000 ALTER TABLE `ms_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_comment`
--

DROP TABLE IF EXISTS `ms_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `create_date` bigint NOT NULL,
  `article_id` bigint NOT NULL,
  `author_id` bigint NOT NULL,
  `parent_id` bigint NOT NULL,
  `to_uid` bigint NOT NULL,
  `level` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `article_id` (`article_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1653679882124591107 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_comment`
--

LOCK TABLES `ms_comment` WRITE;
/*!40000 ALTER TABLE `ms_comment` DISABLE KEYS */;
INSERT INTO `ms_comment` VALUES (53,'鍐欑殑濂?,123213213213,1,1,0,1,'1'),(54,'111',123123123123,1,1,53,1,'2'),(1648245582352822274,'鍝堝搱鍝堝搱',1681807344417,1,1404448588146392386,-1,-1,'1'),(1648245642079711233,'涓轰粈涔堣繖涔堣锛?,1681807358662,1,1404448588146392386,53,1,'2'),(1648246758683127809,'鍝囧搰鍝?,1681807624880,9,1648246717931270145,-1,-1,'1'),(1648254972950695937,'鑽疯姳',1681809583314,9,1648246717931270145,-1,-1,'1'),(1648559374819328002,'鍐欏緱涓嶉敊',1681882158371,1648559336860876802,1648246717931270145,-1,-1,'1'),(1648559764851851265,'杩欏啓鐨勬槸浠€涔?,1681882251366,1648559034279591937,1648246717931270145,-1,-1,'1'),(1648561554121023489,'test',1681882677949,1648559034279591937,1404448588146392386,1648559764851851265,1648246717931270145,'2'),(1648561738993360897,'鎴戠湅鐪?,1681882722040,1648559034279591937,1404448588146392386,1648559764851851265,1648246717931270145,'2'),(1648566069486350337,'娴?,1681883754495,1648559034279591937,1404448588146392386,1648559764851851265,1648246717931270145,'2'),(1648566791070236673,'鑷崠鑷じ涔?,1681883926536,1648559336860876802,1404448588146392386,1648559374819328002,1648246717931270145,'2'),(1648566821055315970,'鍝堝搱鍝?,1681883933690,1648559336860876802,1404448588146392386,-1,-1,'1'),(1648571280716148737,'馃馃馃馃濂藉摝',1681884996960,1648571220905373698,1648246717931270145,-1,-1,'1'),(1652142967692935169,'浠€涔堢敓娲?,1682736553484,1650423232647311362,1648246717931270145,-1,-1,'1'),(1653679231273467906,'12',1683102827265,1650049009814827009,1648246717931270145,-1,-1,'1'),(1653679639756734466,'43242',1683102924657,1650049009814827009,1648246717931270145,-1,-1,'1'),(1653679719649837057,'111',1683102943716,1650049009814827009,1648246717931270145,-1,-1,'1'),(1653679882124591106,'cc',1683102982449,1650049009814827009,1648246717931270145,-1,-1,'1');
/*!40000 ALTER TABLE `ms_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_permission`
--

DROP TABLE IF EXISTS `ms_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_permission`
--

LOCK TABLES `ms_permission` WRITE;
/*!40000 ALTER TABLE `ms_permission` DISABLE KEYS */;
INSERT INTO `ms_permission` VALUES (1,'鏌ヨ鏉冮檺鍒楄〃','/admin/permission/permissionList','鏌ヨ鏉冮檺鍒楄〃'),(8,'鍒犻櫎鏉冮檺','/admin/permission/add','鍒犻櫎鏉冮檺'),(12,'new','/path/aaa/','desc...');
/*!40000 ALTER TABLE `ms_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_sys_log`
--

DROP TABLE IF EXISTS `ms_sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_sys_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_date` bigint DEFAULT NULL,
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `module` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `operation` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `time` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_sys_log`
--

LOCK TABLES `ms_sys_log` WRITE;
/*!40000 ALTER TABLE `ms_sys_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ms_sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_sys_user`
--

DROP TABLE IF EXISTS `ms_sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '璐﹀彿',
  `admin` bit(1) DEFAULT NULL COMMENT '鏄惁绠＄悊鍛?,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '澶村儚',
  `create_date` bigint DEFAULT NULL COMMENT '娉ㄥ唽鏃堕棿',
  `deleted` bit(1) DEFAULT NULL COMMENT '鏄惁鍒犻櫎',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '閭',
  `last_login` bigint DEFAULT NULL COMMENT '鏈€鍚庣櫥褰曟椂闂?,
  `mobile_phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鎵嬫満鍙?,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鏄电О',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '瀵嗙爜',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鍔犲瘑鐩?,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '鐘舵€?,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1648246717931270146 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_sys_user`
--

LOCK TABLES `ms_sys_user` WRITE;
/*!40000 ALTER TABLE `ms_sys_user` DISABLE KEYS */;
INSERT INTO `ms_sys_user` VALUES (1,'admin',_binary '','/static/img/default_avatar_1.png',20210622223122,_binary '\0','11',20210630223130,'12','鍙傚','15f08f86435b060236fa9ccea751e9e5','12','1'),(1404446129264832513,'lisi',_binary '','/static/img/default_avatar_4.png',1623681025218,_binary '\0','',1623681025218,NULL,'鏄村','1d01d52c40f4ff57ad3f93a06daf21d5','',''),(1404448463944462338,'12213',_binary '','/static/img/default_avatar_3.png',1623681581855,_binary '\0','',1623681581855,NULL,'澶╃帒','8628d1f407f72e10ac947a032fe5ad29','',''),(1404448588146192386,'123',_binary '','/static/img/default_avatar_2.png',1623681611474,_binary '\0','',1623681611474,NULL,'澶╃拠','5e112646dbf3570f8e23d0cf1027ede1','',''),(1404448588146392386,'linyun',_binary '','/static/img/default_avatar_1.png',1623681611474,_binary '\0','',1623681611474,NULL,'鏋椾簯','a920960eac88528d40f2b3dc0b0c79f3','',''),(1648246717931270145,'yunfei',_binary '','/static/img/default_avatar_4.png',1681807615159,_binary '\0','',1681807615159,NULL,'yunfei','529eb1bcabde2cbe17cf4a40dfd71b27','','');
/*!40000 ALTER TABLE `ms_sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ms_tag`
--

DROP TABLE IF EXISTS `ms_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ms_tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tag_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ms_tag`
--

LOCK TABLES `ms_tag` WRITE;
/*!40000 ALTER TABLE `ms_tag` DISABLE KEYS */;
INSERT INTO `ms_tag` VALUES (5,'/static/tag/java.png','springboot'),(6,'/static/tag/java.png','spring'),(7,'/static/tag/java.png','springmvc'),(8,'/static/tag/css.png','spring cloud');
/*!40000 ALTER TABLE `ms_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-03 19:38:46
