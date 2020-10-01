// $(function () {
//     $(window).on('scroll', function () {
//         if ( $(window).scrollTop() > 10 ) {
//             $('.navbar').addClass('active');
//         } else {
//             $('.navbar').removeClass('active');
//         }
//     });
// });

$('#prospects_form').submit(function() {
    if ($.trim($("#foodKg").val()) === "" || $.trim($("#price").val()) === "" || $.trim($("#wastePerWeek").val()) === "") {
        alert('Du skal udfylde alle felterne');
        return false;
    }
});

// $("#prospects_form").submit(function(e) {
//     e.preventDefault();
// });
//
// alert("Hello! I am an alert box!!");