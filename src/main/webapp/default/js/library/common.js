//function count to

var Dashboard = {
    login: function () {
        $(document).ready(function () {
            $('#custommer-login').click(function () {
                var that = $(this);

                var form = that.closest('form[name="login"]');
                var email = form.find('input[name="email"]').val();
                var password = form.find('input[name="password"]').val();
                $.ajax({
                    type: "POST",
                    url: urlLogin,
                    cache: false,
                    dataType: 'json',
                    data: {
                        email: email,
                        password: password,
                        ajax: 1
                    },
                    beforeSend: function () {
                        that.find('i').show();
                    },
                    success: function (result) {
                        if (result.error) {
                            var opject = result.messegs;
                            strings = '';
                            $.each(opject, function (key, value) {
                                strings += value + '<br>';
                            });

                            $("#alertLogin").show();
                            $("#alertLogin").find('p').html(strings);
                        } else {
                            window.location.href = baseURL + '/tao-van-don';
                        }

                        that.find('i').hide();
                    }
                });
            });
        });
    },
};


var CustomerPopup = {
    register: function () {
        $(document).ready(function () {

            $("#frmRegister").validate({
                ignore: '.ignore',
                rules: {
                    customerName: {required: true, minlength: 3, maxlength: 255},
                    email: {required: true, minlength: 3, maxlength: 255, email: true},
                    address: {required: true, minlength: 5, maxlength: 255},
                    cityId: {required: true, greaterThanZero: true},
                    wardId: {required: true, greaterThanZero: true},
                    districtId: {required: true, greaterThanZero: true},
                    phone: {required: true, number: true},
                    password: {required: true, maxlength: 255, minlength: 3},
                    rePassword: {required: true, maxlength: 255, minlength: 3, equalTo: "#password"}
                }, messages: {
                    customerName: {
                        required: 'Xin vui lòng nhập Họ và Tên.',
                        minlength: 'Họ và tên tối thiểu từ 3 kí tự trở lên.',
                        maxlength: 'Họ và tên tối đa 255 kí tự'
                    },
                    email: {
                        required: 'Xin vui lòng nhập Email',
                        email: 'Xin vui lòng nhập đúng định dạng email. Ví dụ : hotro@proship.vn',
                        minlength: 'Email tối thiểu từ 3 kí tự trở lên.',
                        maxlength: 'Email tối đa 255 kí tự'
                    },
                    address: {
                        required: 'Xin vui lòng nhập địa chỉ',
                        minlength: 'Địa chỉ tối thiểu từ 5 kí tự trở lên.',
                        maxlength: 'Địa chỉ tối đa 255 kí tự'
                    },
                    phone: {
                        required: 'Số di động không được để trống',
                        number: 'Số điện thoại chỉ chấp nhận ký tự là số.',
                    },
                    password: 'Mật khẩu không được để trống. Tối thiểu trên 3 kí tự và tối đa 255 kí tự',
                    rePassword: 'Vui lòng nhập lại mật khẩu.',
                    cityId: 'Vui lòng chọn Tỉnh/Thành',
                    wardId: 'Vui lòng chọn Phường/Xã',
                    districtId: 'Vui lòng chọn Quận/Huyện'
                }
            });

            jQuery.extend(jQuery.validator.messages, {
                equalTo: "Password không trùng khớp. Xin vui lòng kiểm tra lại"
            });

            $.validator.addMethod("validateAddress", function (value, element) {
                return validateAddress(value);
            }, "Vui lòng nhập số nhà và tên đường đúng định dạng. Ví dụ: 1 Lê Duẩn");

            $.validator.addMethod("greaterThanZero", function (value, element) {
                return this.optional(element) || (parseFloat(value) > 0);
            }, "* Amount must be greater than zero");

            //$("#phone").inputmask({"mask": "9999999999[9]"});

            CustomerPopup.selectCity();

            $('#btnRegister').click(function () {
                form = $(this).closest('form#frmRegister');
                arrayInput = form.serialize();
                $.ajax({
                    type: "POST",
                    url: getRegisterUrl,
                    cache: false,
                    dataType: 'json',
                    data: arrayInput + '&ajax=1',
                    beforeSend: function () {
                    },
                    success: function (result) {
                        if (result.error == 0) {
                            window.location = window.location;
                        } else {
                            var opject = result.messegs;
                            strings = '';
                            $.each(opject, function (key, value) {
                                strings += value + '<br>';
                            });
                            $("#alertRegitter").removeAttr("style");
                            $("#alertRegitter").find('p').html(strings);
                        }
                    }
                });
            });
        });
    },
    selectCity: function () {
        $('#cityId').change(function () {
            cityId = $(this).val();
            var that = $(this);

            var district = $('#districtId');
            var ward = $('#wardId');

            if (cityId) {
                $.ajax({
                    type: "POST",
                    url: getDistrictURL,
                    cache: false,
                    dataType: 'json',
                    data: {
                        cityId: cityId
                    },
                    beforeSend: function () {
                        district.attr('disabled', true);
                        ward.html('<option value="">Vui lòng chọn Phường / Xã</option>').attr('disabled', true);
                    },
                    success: function (result) {
                        if (result.error == 0) {
                            district.html('<option value="">Vui lòng chọn Quận / Huyện</option>');
                            $.each(result.data, function (key, value) {
                                district.append('<option value="' + value.districtId + '">' + value.districtName + '</option>');
                            });

                            district.attr('disabled', false);
                        } else {
                            bootbox.alert(result.message);
                        }
                    }
                });
            }

            return false;
        });

        $('#districtId').change(function () {
            districtId = $(this).val();
            var that = $(this);
            var ward = $('#wardId');

            if (districtId) {
                $.ajax({
                    type: "POST",
                    url: getWardURL,
                    cache: false,
                    dataType: 'json',
                    data: {
                        districtId: districtId
                    },
                    success: function (result) {
                        if (result.error == 0) {
                            ward.html('<option value="">Vui lòng chọn Phường / Xã</option>');
                            $.each(result.data, function (key, value) {
                                ward.append('<option value="' + value.wardId + '">' + value.wardName + '</option>');
                            });

                            ward.attr('disabled', false);
                        } else {
                            bootbox.alert(result.message);
                        }
                    }
                });
            }

            return false;
        });

        //$('#cityId').change();
    },
    add: function () {
        $('select.city').change(function () {
            var cityID = $(this).val();
            var district = $(this).closest('.location').find('.district');

            if (cityID) {
                $.ajax({
                    type: "POST",
                    url: getDistrictURL,
                    cache: false,
                    dataType: 'json',
                    data: {
                        cityId: cityID
                    },
                    beforeSend: function () {
                        district.attr('disabled', true);
                        district.html('<option value="">Vui lòng chọn Quận / Huyện</option>').attr('disabled', true);
                    },
                    success: function (result) {
//	                        console.log(result); return false;
                        if (result.error == 0) {
                            district.html('<option value="">Vui lòng chọn Quận / Huyện</option>').removeAttr('disabled');
                            $.each(result.data, function (key, value) {
                                district.append('<option value="' + value.districtId + '">' + value.districtName + '</option>');
                            });
                        } else {
                            bootbox.alert('Không thể lấy dữ liệu Quận / Huyện');
                        }
                    }
                });
            }
        });

        $('.district').change(function () {
            var districtID = $(this).val();
            var ward = $(this).closest('.location').find('.ward');

            if (districtID) {
                $.ajax({
                    type: "POST",
                    url: getWardURL,
                    cache: false,
                    dataType: 'json',
                    data: {
                        districtId: districtID
                    },
                    beforeSend: function () {
                        ward.attr('disabled', true);
                        ward.html('<option value="">Vui lòng chọn Phường / Xã</option>').attr('disabled', true);
                    },
                    success: function (result) {
                        if (result.error == 0) {
                            ward.html('<option value="">Vui lòng chọn Phường / Xã</option>').removeAttr('disabled');
                            $.each(result.data, function (key, value) {
                                ward.append('<option value="' + value.wardId + '">' + value.wardName + '</option>');
                            });
                        } else {
                            bootbox.alert('Không thể lấy dữ liệu Phường / Xã');
                        }
                    }
                });
            }
        });

    }
};

$(document).ready(function () {
    if ($('.date-mask').length) {
        $('.date-mask').inputmask({"mask": "99/99/9999"});
    }

    if ($('.date-time-mask').length) {
        $('.date-time-mask').inputmask({"mask": "99/99/9999 99:99"});
    }

    if ($('.date-second-mask').length) {
        $('.date-second-mask').inputmask({"mask": "99/99/9999 99:99:99"});
    }

    if ($('.price-mask').length) {
        $('.price-mask').inputmask({
            alias: 'decimal',
            radixPoint: ',',
            groupSeparator: '.',
            autoGroup: true,
            rightAlign: false,
            autoUnmask: true,
            removeMaskOnSubmit: true,
            digits: 0
        });
    }
    /**
     * Alert Message
     */
    if ((typeof sentMailResetPasswordSuccess != 'undefined' && sentMailResetPasswordSuccess) || (typeof customerResetPasswordSuccess != 'undefined' && customerResetPasswordSuccess)) {
        var message = sentMailResetPasswordSuccess || customerResetPasswordSuccess;
        bootbox.alert(message);
    }


    //search
    $('.btn_search').click(function () {
        var frm = $(this).closest('form');
        var invoiceCode = $.trim(frm.find('input').val());

        if (invoiceCode) {
            frm.submit();
        }

        return false;
    });

    //widget click
    $('.widget .widget-title .widget-title-name .widget-expand-content').on('click', function () {
        var parent = $(this).parent().parent().parent();
        if (parent.hasClass('active')) {
            parent.removeClass('active');
            $('.widget-content', parent).slideUp();
            $(this).removeClass('fa-angle-up').addClass('fa-angle-down');
        } else {
            parent.addClass('active');
            $('.widget-content', parent).slideDown();
            $(this).removeClass('fa-angle-down').addClass('fa-angle-up');
        }
    });

    //hover support phone loop , livechat-girl
    setInterval(function () {
        $('.livechat-girl .animated-circles').addClass('animated');
        setTimeout(function () {
            $('.livechat-girl .animated-circles').removeClass('animated');
        }, 5000);
    }, 10000);
    $('.livechat-girl').hover(
            function () {
                $('.popover', $(this)).css({'display': 'block'}).addClass('fade in');
            },
            function () {
                $('.popover', $(this)).css({'display': 'none'}).removeClass('fade in');
            }
    );

    /**
     * Popup Ads
     */
    var cookieName = 'eventPopupClosed_v10';
    var isPopupClosed = true; //readCookie(cookieName);
    if (!isPopupClosed) {
        $.ajax({
            type: 'GET',
            url: getNotifyPopupUrl,
            data: {},
            beforeSend: function () {
                
            },
            success: function (result) {
                bootbox.dialog({
                    message: result,
                    closeButton: false,
                    size: 'large',
                    title: '<h2 class="text-center">Proship Thông Báo</h2>',
                    buttons: {
                        main: {
                            label: "Đóng",
                            className: "btn-primary",
                            callback: function () {
                                createCookie(cookieName, 1, 7);
                            }
                        }
                    }
                }).off('shown.bs.modal');
            }
        });
    }
});




function createCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else
        var expires = "";
    document.cookie = name + "=" + value + expires + "; path=/";
}
function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ')
            c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) === 0)
            return c.substring(nameEQ.length, c.length);
    }
    return null;
}
function eraseCookie(name) {
    createCookie(name, "", -1);
}
var homeCount = function () {
    var viewport = $(window).width();
    if (viewport > 991) {
        $('.counting').one('inview', function (event, visible) {
            if (visible) {
                $('.count-number').countTo({
                    speed: 4500,
                    refreshInterval: 25,
                    formatter: function (value, options) {
                        return value.toFixed(options.decimals);
                    }
                });
            }
        });
    }
};

$(document).ready(function () {
    //expand submenu
    $('.expand-menu').click(function (e) {
        e.preventDefault();
        var menu = $('.menu');
        if (menu.hasClass('menu-tiny')) {
            $(this).removeClass('active');
            menu.removeClass('menu-tiny')
                    .slideUp();
            $('.header').addClass('header-mobile');
        } else {
            $(this).addClass('active');
            menu.addClass('menu-tiny')
                    .slideDown();
            $('.header').removeClass('header-mobile');
        }
    });

    //expand submenu
    $('.menu .btn-submenu').click(function (e) {
        e.preventDefault();
        var grand = $(this).parent().parent();
        var root = $(this).parent().parent().parent();
        if ($(this).hasClass('fa-plus')) {
            $(this).removeClass('fa-plus');
            $(this).addClass('fa-minus');
            $('li.mobile-active > .submenu', $(root)).slideUp();
            $('li.mobile-active > a > .btn-submenu', $(root)).removeClass('fa-minus');
            $('li.mobile-active > a > .btn-submenu', $(root)).addClass('fa-plus');
            $('li.mobile-active', $(root)).removeClass('mobile-active').addClass('mobile-hidden');
            $(grand).addClass('mobile-active').removeClass('mobile-hidden');
            $('>.submenu', $(grand)).slideDown();
        } else {
            $(this).removeClass('fa-minus');
            $(this).addClass('fa-plus');
            $(grand).removeClass('mobile-active').addClass('mobile-hidden');
            $('>.submenu', $(grand)).slideUp();
        }
    });

    //header news slider
    var hnslider = $('#hnslider');
    hnslider.owlCarousel({
        items: 1,
        loop: true,
        margin: 0,
        responsiveClass: false,
        nav: false,
        dots: false,
        autoplay: true,
        autoHeight: false,
        mouseDrag: false,
        touchDrag: false,
        animateOut: 'fadeOutUp',
        animateIn: 'fadeInUp',
        autoplayTimeout: 6000,
        autoplaySpeed: 1000,
        autoplayHoverPause: false,
        navText: false,
        onInitialize: function (event) {
            if ($('.owl-carousel .hn-item').length <= 1) {
                this.settings.loop = false;
            }
        }
    });

    //map click button
    $('.powerful-list').find('.powerful-item').first().addClass('active');
    $('.powerful-list').find('.powerful-item-content').first().show();
    $('.powerful-item .powerful-item-btn').on('click', function (e) {
        e.preventDefault();
        var parent = $(this).parent();
        var grand = $(this).parent().parent();
        var x = $(this).attr('href');
        $('.powerful-list .powerful-item.active .powerful-item-content').slideUp();
        $('.powerful-list .powerful-item.active').removeClass('active');
        $(grand).addClass('active');
        $('.powerful-item-content', $(grand)).slideDown();
        $('.powerful-map img').attr('src', x);
    });

    //client slider
    $('#clientslider').owlCarousel({
        loop: true,
        margin: 25,
        responsiveClass: true,
        nav: true,
        dots: false,
        autoplay: true,
        autoHeight: false,
        autoplayTimeout: 4000,
        autoplayHoverPause: false,
        navText: false,
        responsive: {
            0: {
                items: 1
            },
            641: {
                items: 2
            },
            992: {
                items: 3
            }
        },
        onInitialize: function (event) {
            if ($('.owl-carousel .client-item').length <= 1) {
                this.settings.loop = false;
            }
        }
    });

    //partner sslider
    $('#logoslider').owlCarousel({
        loop: true,
        margin: 10,
        responsiveClass: true,
        nav: true,
        dots: false,
        autoplay: true,
        autoHeight: false,
        autoplayTimeout: 4000,
        autoplayHoverPause: false,
        navText: false,
        responsive: {
            0: {
                items: 1
            },
            481: {
                items: 2
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1200: {
                items: 5
            }
        },
        onInitialize: function (event) {
            if ($('.owl-carousel .logo-item').length <= 1) {
                this.settings.loop = false;
            }
        }
    });

    //near click button
    $('.pro-near-list').find('.pro-near-item').first().addClass('active');
    $('.pro-near-list').find('.pro-near-item-content').first().show();
    $('.pro-near-map').find('.hcmc').show();
    $('.pro-near-item .pro-near-item-btn').on('click', function (e) {
        e.preventDefault();
        var parent = $(this).parent();
        var grand = $(this).parent().parent();
        var place = $(grand).attr('data-place');
        $('.pro-near-list .pro-near-item.active .pro-near-item-content').slideUp();
        $('.pro-near-list .pro-near-item.active').removeClass('active');
        $(grand).addClass('active');
        $('.pro-near-item-content', $(grand)).slideDown();
        $('.pro-near-point').hide();
        $('.' + place).show();
    });

    //scroll pro near block
    $('.pro-near-scroll').slimScroll({
        height: 175,
        color: '#333333',
    });

    //home counting
    homeCount();

    // button go #feeauto
    $('.go-free-auto').click(function (e) {
        e.preventDefault();
        $("html, body").animate({scrollTop: $('#feeauto').offset().top}, 700);
    });

    //scroll to #feeauto
    $('.scroll-down').click(function (e) {
        e.preventDefault();
        $('html, body').animate({scrollTop: $('#feeauto').offset().top}, 800);
    });

    //support click
    var supportOpen = $('.v2-support .v2-support-li .v2-support-open');
    supportOpen.on('click', function () {
        var parent = $(this).parent();
        if (parent.hasClass('active') === false) {
            parent.addClass('active');
        }
    });
    var supportClose = $('.v2-support .v2-support-li .v2-support-close');
    supportClose.on('click', function (e) {
        e.preventDefault();
        var parent = $(this).parent();
        if (parent.hasClass('active')) {
            parent.removeClass('active');
        }
    });

    //footer menu mobile click
    $('.footer-label .fa').click(function () {
        var grand = $(this).parent().parent();
        if ($(this).hasClass("fa-plus")) {
            $('.footer .footer-label .fa').removeClass("fa-minus").addClass("fa-plus");
            $('.footer-content', $('.footer')).slideUp();
            $(this).removeClass("fa-plus");
            $(this).addClass("fa-minus");
            $('.footer-content', $(grand)).slideDown();
        } else {
            $(this).removeClass("fa-minus");
            $(this).addClass("fa-plus");
            $('.footer-content', $(grand)).slideUp();
        }
    });

    //expand footer submenu
    $('.footer-about-list .fal-btn-submenu').click(function (e) {
        e.preventDefault();
        var grand = $(this).parent().parent();
        var root = $(this).parent().parent().parent();
        if ($(this).hasClass('fa-plus')) {
            $(this).removeClass('fa-plus');
            $(this).addClass('fa-minus');
            $('li.mobile-active > .fal-submenu', $(root)).slideUp();
            $('li.mobile-active > a > .fal-btn-submenu', $(root)).removeClass('fa-minus');
            $('li.mobile-active > a > .fal-btn-submenu', $(root)).addClass('fa-plus');
            $('li.mobile-active', $(root)).removeClass('mobile-active').addClass('mobile-hidden');
            $(grand).addClass('mobile-active').removeClass('mobile-hidden');
            $('>.fal-submenu', $(grand)).slideDown();
        } else {
            $(this).removeClass('fa-minus');
            $(this).addClass('fa-plus');
            $(grand).removeClass('mobile-active').addClass('mobile-hidden');
            $('>.fal-submenu', $(grand)).slideUp();
        }
    });

    //call select search keyword
    $(".js-states").select2();

    //expand search
    $('.expand-search').click(function (e) {
        e.preventDefault();
        var boxSearch = $('.box-search');
        if (boxSearch.hasClass('search-active')) {
            $(this).removeClass('active');
            $('.fa', $(this)).removeClass('fa-times').addClass('fa-search');
            boxSearch.removeClass('search-active')
                    .hide();
        } else {
            $(this).addClass('active');
            $('.fa', $(this)).removeClass('fa-search').addClass('fa-times');
            boxSearch.addClass('search-active')
                    .show();
        }
    });

    $('.fp-item:eq(0)', $('.fp-list')).addClass('active');
    $('.fp-item:eq(0) .fp-item-title .fp-caret', $('.fp-list')).removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
    $('.fp-item:eq(0) .fp-item-content', $('.fp-list')).show();
    $('.fp-item .fp-item-title').on('click', function () {
        var faqList = $('.fp-list');
        var parent = $(this).parent();
        if (parent.hasClass('active')) {
            parent.removeClass('active');
            $('.fp-item-content', parent).slideUp();
            $('.fp-caret', $(this)).removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
        } else {
            $('.fp-item.active .fp-item-content', faqList).slideUp();
            $('.fp-item.active .fp-item-title .fp-caret', faqList).removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
            $('.fp-item.active', faqList).removeClass('active');
            parent.addClass('active');
            $('.fp-item-content', parent).slideDown();
            $('.fp-caret', $(this)).removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
        }
    })

    //fee pro slider
    $('#fislider').owlCarousel({
        items: 1,
        loop: true,
        margin: 0,
        responsiveClass: false,
        nav: true,
        dots: false,
        autoplay: true,
        autoHeight: false,
        autoplayTimeout: 6000,
        autoplaySpeed: 1000,
        autoplayHoverPause: false,
        navText: false,
        onInitialize: function (event) {
            if ($('.owl-carousel .fee-info-item').length <= 1) {
                this.settings.loop = false;
            }
        }
    });

    //check input fee pro calulate
    $('.fee-pro-checkbox').on('click', function () {
        var id = $(this).attr('data-content');
        var inputText = $('#' + id);
        if (inputText.attr('disabled')) {
            inputText.removeAttr('disabled');
            $(this).attr('checked', true);
        } else {
            inputText.attr('disabled', 'disabled');
            $(this).attr('checked', false);
        }
    });

    $('.faq-item .faq-item-title').on('click', function () {
        var faqList = $('.faq-list');
        var parent = $(this).parent();
        if (parent.hasClass('active')) {
            parent.removeClass('active');
            $('.faq-item-content', parent).slideUp();
            $('.faq-caret', $(this)).removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
        } else {
            $('.faq-item.active .faq-item-content', faqList).slideUp();
            $('.faq-item.active .faq-item-title .faq-caret', faqList).removeClass('fa-angle-double-up').addClass('fa-angle-double-down');
            $('.faq-item.active', faqList).removeClass('active');
            parent.addClass('active');
            $('.faq-item-content', parent).slideDown();
            $('.faq-caret', $(this)).removeClass('fa-angle-double-down').addClass('fa-angle-double-up');
        }
    });

});

(function($, window, document){
    'use strict';

    $(document).ready(function(){
        var homeSliderBlockEle = $('.js-home-slider-block');
        if(!homeSliderBlockEle.length) {
            return;
        }

        var paginationEle = homeSliderBlockEle.find('.swiper-pagination');
        var sliderContainerEle = homeSliderBlockEle.find('.slider-container');
        var prevBtnEle = homeSliderBlockEle.find('.swiper-button-prev');
        var nextBtnEle = homeSliderBlockEle.find('.swiper-button-next')

        var mySwiper = new Swiper(sliderContainerEle, {
            pagination: paginationEle,
            paginationClickable: true,
            simulateTouch: true,
            keyboardControl: true,
            nextButton: nextBtnEle,
            prevButton: prevBtnEle,
            effect: 'fade',
            loop: true,
            speed: 300,
        });
    });//end document ready
})(jQuery, window, document);
