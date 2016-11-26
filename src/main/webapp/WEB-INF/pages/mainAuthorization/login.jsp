<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Taiton Bank</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon">

        <link rel="stylesheet" href="css/normalize.css">
        <link href="css/style.css" type="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="libs/font-awesome-4.7.0/css/font-awesome.min.css">
<%--
        <script src="js/vendor/modernizr-2.8.3.min.js"></script>
--%>

        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    </head>
    <body>
        <!--[if lt IE 8]>
<!--
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
-->


       <section class="main-banner">
           <div class="container">
               <h1 class="main-title">Taiton Bank <br>всегда с вами!</h1>
                <button class="test-popup-btn center-popup-btn">Войти в банк</button>
           </div>
       </section>
        <section class="about-us">
            <div class="container">
                <h2 class="second-title">Любите свои деньги и распоряжайтесь ими по-новому</h2>
                <div class="plus-container">
                    <div class="plus-info">
                        <div class="info-logo">
                        <i class="fa fa-line-chart" aria-hidden="true"></i>
                        </div>
                        <h3>Новый дизайн —<br>
                            новый взгляд</h3>
                        <span>Постоянный контроль за историей<br> расходов, остатками на<br> счетах, — все это<br> в новом наглядном интерфейсе</span>
                    </div>
                </div>
                <div class="plus-container">
                    <div class="plus-info">
                        <div class="info-logo">
                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                        </div>
                        <h3>Отделение банка
                            24 часа в сутки</h3>
                        <span>Оплата телефона, <br>коммунальных услуг<br> и много другого не отходя<br> от компьютера или телефона</span>
                    </div>
                </div>
                <div class="plus-container">
                    <div class="plus-info">
                        <div class="info-logo">
                            <i class="fa fa-mobile" aria-hidden="true"></i>
                        </div>
                        <h3>Работает на любом устройстве</h3>
                        <span>Пользуйтесь банкингом с любого<br> устройства, где есть выход в интернет<br> через сайт</span>
                    </div>
                </div>
                <div class="plus-container">
                    <div class="plus-info">
                        <div class="info-logo">
                            <i class="fa fa-rocket" aria-hidden="true"></i>
                        </div>
                        <h3>Расширенные возможности</h3>
                        <span>Переводы в пару кликов, автооплата,<br> возможность управлять карточками<br> и счетами</span>
                    </div>
                </div>
            </div>
        </section>
        <section class="easy-using">
            <div class="container">
                <h2>Легкость в использовании!</h2>
            </div>
        </section>
        <section class="footer">
            <span>© 2016 OAO <a>«Taiton Bank»</a></span>
        </section>

        <!--popup-block-->

      <%--  <div id="modal-test" class="modal-container">
            <div class="shade"></div>

                    <form class="sign-up" method="post" action="/login" modelAttribute="userForm">
                        <h1 class="sign-up-title">Вход в банк</h1>
                        <input type="text" name="name" class="sign-up-input" placeholder="Имя пользователя" autofocus>
                        <input type="password" name="password" class="sign-up-input" placeholder="Введите пароль">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" value="Войти!" class="sign-up-button icon-arrow-right">
                        <div class="popup-icon close-modal">x</div>
                    </form>

        </div>--%>

<%--        <div id="modal-test" class="modal-container">
            <div class="shade"></div>
            <form method="POST" action="${contextPath}/login" class="sign-up">
                <h1 class="sign-up-title">Вход в банк</h1>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="sign-up-input" placeholder="Имя пользователя" autofocus="true"/>
                    <input name="password" type="password" class="sign-up-input" placeholder="Введите пароль"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <button class="sign-up-button icon-arrow-right" type="submit">Log In</button>
                    <div class="popup-icon close-modal">x</div>
                    &lt;%&ndash;<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>&ndash;%&gt;
                </div>

            </form>

        </div>--%>

        <div class="container">

            <form method="POST" action="${contextPath}/login" class="form-signin">
                <h2 class="form-heading">Log in</h2>

                <div class="form-group ${error != null ? 'has-error' : ''}">
                    <span>${message}</span>
                    <input name="username" type="text" class="form-control" placeholder="Username"
                           autofocus="true"/>
                    <input name="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                    <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
                </div>

            </form>

        </div>

        <body>



        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
        <script src="js/plugins.js"></script>
        <%--<script src="js/main.js"></script>--%>
        <script src="libs/less.min.js"></script>
        <script src="js/popup.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='https://www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>

    </body>
</html>
