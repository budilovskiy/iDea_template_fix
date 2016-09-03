if (Modernizr.mq('only all and (max-width: 767px)') || Modernizr.touch || $(".main-navigation.onclick").length>0 ) {
$('.header-top [data-toggle=dropdown]').on('click', function(event) {
// Avoid following the href location when clicking
//event.preventDefault();
// Avoid having the menu to close when clicking
event.stopPropagation(); 
// close all the siblings
$(this).parent().siblings().removeClass('open');
// close all the submenus of siblings
$(this).parent().siblings().find('[data-toggle=dropdown]').parent().removeClass('open');
// opening the one you clicked on
$(this).parent().toggleClass('open');
});
};
// dropdown menu with hover
$(".main-navigation li.dropdown").bind({
mouseenter: function (e) {
if ($(window).width() > 767) {
var $li = $(this);
showTimeout = setTimeout(function () {
$li.find("> ul.dropdown-menu", this).fadeIn("fast");
$li.addClass("open");
}, 0);
}
},
mouseleave: function (e) {
if ($(window).width() > 767) {
clearTimeout(showTimeout);
$(this).find("ul.dropdown-menu").hide();
$(this).removeClass("open");
}
},
click : function (e) {
clearTimeout(showTimeout);
}
});
