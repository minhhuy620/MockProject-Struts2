var Comments = {
    opinion: function () {
        $(document).ready(function () {
            /**
             * Send Comment
             */
            $("#btn-send-comment").click(function () {
                var form = $(this).closest('form');
                var fullName = form.find('.fullName').val();
                var commentEmail = form.find('.commentEmail').val();
                var commentPhone = form.find('.commentPhone').val();
                var content = form.find('.content').val();
                var customerId = form.find('.customerId').val();

                $.ajax({
                    type: "POST",
                    url: urlAddComment,
                    cache: false,
                    dataType: 'json',
                    data: {
                        fullName: fullName,
                        commentEmail: commentEmail,
                        commentPhone: commentPhone,
                        content: content,
                        customerId: customerId,
                    },
                    beforeSend: function () {

                    },
                    success: function (result) {
                        if (result.error == 1) {
                            alert(result.message);
                        } else {
                            $('.comment-list > ul').prepend(result.data);
                            form.find('.content').val('');

                            Comments.replyComment();

                            alert(result.message);
                        }
                    }
                });
            });

            /**
             * Reply comment
             */
            $('.comment-list').on('click', '.reply-comment', function (e) {
                e.preventDefault();
                var that = $(this);
                $('.reply-comment-container').html('');

                var html = $('#comment-content').html();
                that.parent().parent().find('.reply-comment-container').html(html).fadeIn();

            });

            Comments.replyComment();
        });
    },
    contacts: function () {
        $(document).ready(function () {
            $("#send-contact-form").click(function () {
                var form = $(this).closest('form');
                var fullName = form.find('.fullName').val();
                if (fullName == '') {
                    bootbox.alert('Họ tên không được trống');
                    return false;
                }
                var commentsEmail = form.find('.commentsEmail').val();
                if (commentsEmail == '') {
                    bootbox.alert('Email không được trống');
                    return false;
                }
                var commentsPhone = form.find('.commentsPhone').val();
                if (commentsPhone == '') {
                    bootbox.alert('Số điện thoại không được trống');
                    return false;
                }
                if (commentsPhone.length < 8 || commentsPhone.length > 11) {
                    bootbox.alert('Số điện thoại không hợp lệ');
                    return false;
                }
                var content = form.find('.content').val();
                if (content == '') {
                    bootbox.alert('Nội dung không được trống');
                    return false;
                }

                $.ajax({
                    type: "POST",
                    url: urlAddContact,
                    cache: false,
                    dataType: 'json',
                    data: {
                        fullName: fullName,
                        commentEmail: commentsEmail,
                        content: content,
                        commentPhone: commentsPhone
                    },
                    beforeSend: function () {

                    },
                    success: function (result) {

//                            bootbox.alert(result.html.toSource());

                        bootbox.alert(result.html);
                        if (result.error == 1) {
                            form.find('input').val('');
                            form.find('textarea').val('');
                        }
                    }
                });
            });
        });
    },
    replyComment: function () {
        $('.comment-list').on('click.comment', '.send-reply-comment', function () {
            var _topParent = $(this).closest('.reply-comment-container');
            var parentID = _topParent.data('comment-id');

            var fullname = _topParent.find('input[name=fullName]').first().val();
            var email = _topParent.find('input[name=email]').first().val();
            var content = _topParent.find('textarea[name=feedbackContent]').first().val();

            if (!fullname || !email || !content) {
                bootbox.alert('Vui lòng nhập đầy đủ thông tin');

                return false;
            }

            if (parentID > 0) {
                $.ajax({
                    url: replyCommentUrl,
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        parentId: parentID,
                        fullName: fullname,
                        email: email,
                        content: content
                    },
                    success: function (result) {

                        alert(result.message);

                        if (result.error == 0) {
                            _topParent.closest('.comment-container').append(result.data);
                            _topParent.fadeOut(function () {
                                $(this).html('');
                            });
                        }
                    }
                });
            }
        });
        return false;
    }
}
/**
 * Calculate Invoice Fee
 */
var CalculateFee = {
		//calculate fee on homepage
	quickCalculate: function() {
		$('#btn-calculate-fee').click(function() {
			var _this = $(this);
			var frm = $('#frm-fee-auto');
			var calculateUrl = frm.attr('action');
			var formData = frm.serialize();
			
			$.ajax({
                type: "POST",
                url: calculateUrl,
                cache: false,
                data: formData,
                dataType: 'json',
                beforeSend: function () {
                	$('#loading-mask').show();
                },
                success: function (result) {
                	$('#loading-mask').hide();
                	if (result.error == 0) {
                		//#ModalFeeAuto
                    	$("#ModalFeeAuto .modal-content").html(result.data);
                    	$("#ModalFeeAuto").modal();
                	} else {
                		bootbox.alert(result.message);
                	}
                }
            });
        });
	},
    index: function () {
        $(document).ready(function () {
            $('#airPortFrom').change(function () {
                var listAirPort = JSON.parse(arrAirPort);
                var val = $(this).val();
                var xHtml = '<option value="0">Vui lòng chọn sân bay</option>';

                $.each(listAirPort, function (k, v) {
                    var shipping_fix_address_id = v.shipping_fix_address_id;

                    if (shipping_fix_address_id == val) {
                        listAirPort.splice(k, 1);
                        return false;
                    }
                })

                $.each(listAirPort, function (k, v) {
                    xHtml += '<option value="' + v.shipping_fix_address_id + '">' + v.address_title + '</option>';
                })

                $('#airPortTo').html(xHtml);
            });

            $('#officeFrom').change(function () {
                var listOffice = JSON.parse(arrOffice);
                var val = $(this).val();
                var xHtml = '<option value="0">Vui lòng chọn văn phòng / kho</option>';

                $.each(listOffice, function (k, v) {
                    var shipping_fix_address_id = v.shipping_fix_address_id;

                    if (shipping_fix_address_id == val) {
                        listOffice.splice(k, 1);
                        return false;
                    }
                })

                $.each(listOffice, function (k, v) {
                    xHtml += '<option value="' + v.shipping_fix_address_id + '">' + v.address_title + '</option>';
                })

                $('#officeTo').html(xHtml);
            });

            $('#codCost').on('change', function () {
                var codCost = $(this).val();
                $('#codCostFix').val(codCost);
            });
            
            $(document).on('change', '.additional-price', function () {
                var price = $(this).val();
                $('#priceFix').val(price);
            });
            //Schedule time format
            $('input#scheduleTime').inputmask({'mask': '99/99/9999 99:99'});

            $('#insuranceService').change(function () {
                if ($(this).is(':checked')) {
                    $('#price').attr('disabled', false);
                } else {
                    $('#price').attr('disabled', true);
                }
            });

            $('#scheduleService').change(function () {
                if ($(this).is(':checked')) {
                    $('#scheduleTime').attr('disabled', false);
                } else {
                    $('#scheduleTime').attr('disabled', true);
                }
            });

            $('.fix-type-address').click(function () {
                var addressFrom = $(this).data('fix-address-from');
                var addressTo = $(this).data('fix-address-to');

                fixTypeAddress(addressFrom, addressTo);
            });

            /**
             * Preview Price
             */
            CalculateFee.preview();
        });
    },
    preview: function () {
    	$('input.price-preview[type=text]').unbind('blur').blur(function () {
    		CalculateFee.__calculateFee();
        });
    	
        $('select.price-preview, input.price-preview[type=checkbox], input.price-preview[type=radio]').unbind('change.calculateFee').bind('change.calculateFee', function (e) {
        	CalculateFee.__calculateFee();
        });
    },
    createInvoice: function () {
        $(document).on('click', '.btn-create-invoice', function () {
            if (customerId != '') {
                //redirect ve trang tao van don
                var dataCalculate = $('#formCalculateFee').serialize();
                window.location.href = baseURL + '/tao-van-don/?' + dataCalculate;
            } else {
                //Hien popup đăng nhập đăng kí
                $.ajax({
                    type: "GET",
                    url: loginRegisterUrl,
                    beforeSend: function () {
                        $('#loading-mask').show();
                    },
                    data: {
                    },
                    success: function (result) {
                        $('#loading-mask').hide();
                        bootbox.dialog({
                            className: "login-register-container",
                            message: result,
                            title: "Đăng nhập",
                            buttons: {
                                danger: {
                                    label: "Thoát",
                                    className: "btn-danger",
                                    callback: function () {

                                    }
                                },
                            }
                        });

                        $('.login-register-container').on('shown.bs.modal', function (e) {
                            $(document).on('click', '.register-button', function () {
                                $('body .login-register-container .modal-title').text("Đăng Ký");
                                $('body .login-register-container .modal-dialog').css({"width": "60%", "margin": "0 auto"});
                                $('body .login-block').hide();
                                $('body .register-block').show();
                            });

                            $(document).on('click', '.login-button', function () {
                                $('body .login-register-container .modal-title').text("Đăng Nhập");
                                $('body .login-register-container .modal-dialog').removeAttr("style");
                                $('body .register-block').hide();
                                $('body .login-block').show();
                            });

                            //Login
                            $(document).on('click', '.custommer-login', function () {
                                var that = $(this);

                                var form = that.closest('form[name="login"]');
                                var email = form.find('input[name="email"]').val();
                                var password = form.find('input[name="password"]').val();
                                var dataCalculate = $('#formCalculateFee').serialize();
                                $.ajax({
                                    type: "POST",
                                    url: urlLogin,
                                    cache: false,
                                    dataType: 'json',
                                    data: {
                                        email: email,
                                        password: password,
                                        ajax: 1,
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

                                            $(".alertLogin").show();
                                            $(".alertLogin").find('p').html(strings);
                                        } else {
                                            window.location.href = baseURL + '/tao-van-don/?' + dataCalculate;
                                        }

                                        that.find('i').hide();
                                    }
                                });
                            });

                            //Register
                            $(document).on('click', '.btnRegister', function () {
                                var that = $(this);
                                form = $(this).closest('form.frmRegister');
                                arrayInput = form.serialize();
                                var dataCalculate = $('#formCalculateFee').serialize();
                                $.ajax({
                                    type: "POST",
                                    url: getRegisterUrl,
                                    cache: false,
                                    dataType: 'json',
                                    data: arrayInput + '&ajax=1',
                                    beforeSend: function () {
                                        that.find('i').show();
                                    },
                                    success: function (result) {
                                        if (result.error == 0) {
                                            window.location.href = baseURL + '/tao-van-don/?' + dataCalculate;
                                        } else {
                                            var opject = result.messegs;
                                            strings = '';
                                            $.each(opject, function (key, value) {
                                                strings += value + '<br>';
                                            });
                                            $(".alertRegitter").removeAttr("style");
                                            $(".alertRegitter").find('p').html(strings);
                                        }
                                    }
                                });
                            });


                            //choose city
                            $('#cityIdPopup').change(function () {
                                var cityID = $(this).val();
                                $('#districtIdPopup').attr('disabled', 'disabled').html('<option selected="selected" value="">Vui lòng chọn Quận / Huyện</option>');
                                $('#wardIdPopup').attr('disabled', 'disabled').html('<option selected="selected" value="">Vui lòng chọn Phường / Xã</option>');
                                if (cityID) {
                                    $.ajax({
                                        url: baseURL + '/lay-danh-sach-quan-huyen',
                                        type: "POST",
                                        async: true,
                                        cache: false,
                                        dataType: 'json',
                                        data: {
                                            cityId: cityID,
                                            allowDelivery: 1
                                        },
                                        success: function (result) {
                                            if (result) {
                                                $('#districtIdPopup').removeAttr('disabled');
                                                $.each(result.data, function (k, v) {
                                                    $('#districtIdPopup').append('<option value="' + v.districtId + '">' + v.districtName + '</option>');
                                                });
                                            } else {
                                                bootbox.alert('Không thể lấy dữ liệu Quận / Huyện');
                                            }
                                        }
                                    });
                                }
                            });

                            $('#districtIdPopup').change(function () {
                                var districtID = $(this).val();
                                $('#wardIdPopup').attr('disabled', 'disabled').html('<option selected="selected" value="">Vui lòng chọn Phường / Xã</option>');
                                if (districtID) {
                                    $.ajax({
                                        url: baseURL + '/lay-danh-sach-phuong-xa',
                                        type: "POST",
                                        async: true,
                                        cache: false,
                                        dataType: 'json',
                                        data: {
                                            districtId: districtID
                                        },
                                        success: function (result) {
                                            if (result) {
                                                $('#wardIdPopup').removeAttr('disabled');
                                                $.each(result.data, function (k, v) {
                                                    $('#wardIdPopup').append('<option value="' + v.wardId + '">' + v.wardName + '</option>');
                                                });
                                            } else {
                                                bootbox.alert('Không thể lấy dữ liệu Phường / Xã');
                                            }
                                        }
                                    });
                                }
                            });

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
                        });
                    }
                });
            }
        });
    },
    __calculateFee: function () {
    	var isValid = true;
        $('.select-fix-address:visible').each(function() {
        	var selectVal = parseInt( $(this).val() );
        	if (isNaN(selectVal) || selectVal <= 0) {
                isValid = false;
                return;
            }
        });
        var weigh = parseFloat($('#weigh').val());
        if (isNaN(weigh)) {
        	weigh = 0;
        }
        if (weigh <= 0) {
        	isValid = false;
        }
        
        if (isValid === true) {
        	var frm = $('form#frm-estimate-fee');
        	var dataInvoice = frm.find(":input:visible, select:visible").serialize();
        	var calculateFeeURL = frm.attr('action');
        	
        	var fixTypeAddress = $('.shipping-method-type').find('.fp-item.active').data('fix-type-address');
        	dataInvoice += '&fixTypeAddress=' + fixTypeAddress;
        	
            $.ajax({
                type: 'POST',
                url: calculateFeeURL,
                dataType: 'json',
                data: dataInvoice,
                beforeSend: function () {
                	$('#loading-mask').show();
                },
                success: function (result) {
                	$('#loading-mask').hide();
                	
                    if (result.error == 1) {
                        bootbox.alert(result.message);
                        return false;
                    }
                    $('div#calculate-fee-result').html(result.data);
                    
                    //get money click
                    $('.get-title').on('click', function () {
                    	var _this = $(this);
                        var root = _this.parent().parent().parent();
                        var parent = _this.parent();
                        
                        //_this.closest('.create-service').find('input').attr('checked', false);
                        _this.find('input').prop('checked', true);
                        
                        if (!parent.hasClass('active')) {
                            $('.get-box .get-item.active .get-content', root).slideUp();
                            $('.get-box .get-item.active', root).removeClass('active');
                            
                            $(parent).addClass('active');
                            $('.get-content', parent).slideDown();
                        }
                    });
                }
            });
        }
    }
};

//vp - kho sender vận chuyển chuyên tuyến
/**
 * 
 * @param <int> disCityId (cityId disabled) 
 * @returns append html
 */
function getSenderOffice(disCityId) {
    var listOffice = JSON.parse(arrOffice);
    var senderCityId = '';
    var senderDistrictId = '';

    if (typeof invoice != 'undefined') {
        var listInvoice = JSON.parse(invoice);
        senderCityId = listInvoice.senderCity;
        senderDistrictId = listInvoice.senderDistrict;
    }

    $('#senderOffice').html('');
    $('#senderOffice').append('<option value="">Vui lòng chọn văn phòng - kho</option>');

    $.each(listOffice, function (k, v) {
        var selected = '';
        var disabled = '';

        if (typeof disCityId != 'undefined' && v.city_id != disCityId) {
            disabled = 'disabled';
        }

        if (senderCityId == v.city_id && senderDistrictId == v.district_id) {
            selected = 'selected';
        }

        var xHtml = '<option ' +
                'data-city="' + v.city_id + '"' +
                'data-district="' + v.district_id + '"' +
                'data-ward="' + v.ward_id + '"' +
                'value="' + v.shipping_fix_address_id + '" ' + selected + disabled + '>' + v.address_title + '</option>';

        $('#senderOffice').append(xHtml);
    });
}

function fixTypeAddress(addressFrom, addressTo) {
    if (typeof addressFrom == 'undefined' || typeof addressTo == 'undefined') {
        return false;
    }

    $('#fixAddressFrom').val(addressFrom);
    $('#fixAddressTo').val(addressTo);

    switch (addressFrom) {
        case airPortType:
            $('.address-fix-airport-from').removeClass('hide');
            $('.address-fix-office-from').addClass('hide');
            $('.address-default-from').addClass('hide');

            $('.address-fix-airport-from').find('select').val(0);

            break;
        case officePsType:
            $('.address-fix-airport-from').addClass('hide');
            $('.address-fix-office-from').removeClass('hide');
            $('.address-default-from').addClass('hide');

            $('.address-fix-office-from').find('select').val(0);

            break;
        default:
            $('.address-fix-airport-from').addClass('hide');
            $('.address-fix-office-from').addClass('hide');
            $('.address-default-from').removeClass('hide');

            $('.address-default-from').find('select').each(function () {
                $(this).val(0);
            });

            break;
    }

    switch (addressTo) {
        case airPortType:
            $('.address-fix-airport-to').removeClass('hide');
            $('.address-fix-office-to').addClass('hide');
            $('.address-default-to').addClass('hide');

            $('.address-fix-airport-to').find('select').val(0);

            break;
        case officePsType:
            $('.address-fix-airport-to').addClass('hide');
            $('.address-fix-office-to').removeClass('hide');
            $('.address-default-to').addClass('hide');

            $('.address-fix-office-to').find('select').val(0);

            break;
        default:
            $('.address-fix-airport-to').addClass('hide');
            $('.address-fix-office-to').addClass('hide');
            $('.address-default-to').removeClass('hide');

            $('.address-default-to').find('select').each(function () {
                $(this).val(0);
            });

            break;
    }
}
