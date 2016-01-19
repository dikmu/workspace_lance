//Lancer email push
$( function () {
	Lancer.profile.getEmailPush( function(data) {
		var user = data.User;

		//修改email push
		var sf=Data.User.User.SubscribeFrequency;
		var su=Data.User.User.SubscribeUpdate;
		if(sf == 'week') {
			$("#epush_week")[0].checked = true;
		} else if(sf == 'day') {
			$("#epush_day")[0].checked = true;
		} else if(sf == 'no') {
			$("#epush_no")[0].checked = true;
		}
		if(su == 'Y') {
			$("#epush_freq")[0].checked = true;
		} else {
			$("#epush_freq")[0].checked = false;
		}

	});
	
	$("#btn_save").click( function () {
		var btn = $(this);

		var m_param = {
		};

		//set email frequance
		if ($("#epush_day")[0].checked) {
			m_param.SubscribeFrequency = "day";
		} else if ($("#epush_week")[0].checked) {
			m_param.SubscribeFrequency = "week";
		} else if ($("#epush_no")[0].checked) {
			m_param.SubscribeFrequency = "no";
		}
		if ($("#epush_freq")[0].checked) {
			m_param.SubscribeUpdate = "Y";
		} else {
			m_param.SubscribeUpdate = "N";
		}

		btn.button('loading');

		$.ax("post", "user/update/" + User.UserName, m_param, function () {
			$.ae("保存成功!");
			btn.button("reset");
		}, function () {
			netWorkError();
			btn.button("reset");
		},
		"text");

	});
});