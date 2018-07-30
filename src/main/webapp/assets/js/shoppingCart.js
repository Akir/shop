$("button:submit").click(function(){
	var csrfParamName = $('meta[name="_csrf_parameter"]').attr('content');
    var csrfParamValue = $('meta[name="_csrf"]').attr('content');
	var data = {
		operate: $(this).val(),
		quantity: $(this).data('quantity')
	};
	var string = $(this).val();
	var str = string.split(':');
	data[csrfParamName] = csrfParamValue;
	$.ajax('/shop/uc/ShoppingCart',{
		method: 'POST',
		data: data
	}).then(function(cart){
		$('#totalAmount').text('总计:'+(cart.totalAmount/100).toFixed(2));
		if(str[1] == 3){
			$("."+str[0]).remove();
		}
		for(var x in cart.shoppingCartItems){
			if(str[0] == cart.shoppingCartItems[x].cellPhone.id){
				var quantity = cart.shoppingCartItems[x].quantity;
			}
		}
		$('#'+str[0]).text(quantity);
	});
});