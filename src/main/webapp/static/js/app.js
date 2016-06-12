function deleteRecipe(id) {
    $.ajax({
        url : '/api/recipe/' + id,
        type : 'DELETE',
        success : function(response) {
            location.reload();
        }
    });
}

function deleteCuisine(id) {
	$.ajax({
		url : '/admin/cuisine/' + id,
		type : 'DELETE',
		success : function(response) {
			location.reload();
		}
	});
}

function deleteCategory(id) {
	$.ajax({
		url : '/admin/category/' + id,
		type : 'DELETE',
		success : function(response) {
			location.reload();
		}
	});
}

function deleteFoodProduct(id) {
    $.ajax({
        url : '/admin/foodProduct/' + id,
        type : 'DELETE',
        success : function(response) {
            location.reload();
        }
    });
}
function saveEntity(url, formId, alertId) {
	console.log('DATA: ' + formId);
	console.log($('#'+formId).serialize());
	$.ajax({
		url : url,
		type : 'POST',
		data : $('#'+formId).serialize(),
		success : function(response) {
			location.reload();
		},
		error : function(xhr, status, text) {
			console.log('Failure!');
			console.log('Save entity:');
			console.log(status);
			console.log(text);
			$('#' + alertId).show();
			$('#' + alertId).html("Error: " +  xhr.responseJSON.message);
		}
	});
}
