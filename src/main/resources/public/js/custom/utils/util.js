angular.module('myApp').factory('Utils', [function () {


    var utils = {};


    utils.formatAMPM = function (date) {
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var ampm = hours >= 12 ? 'PM' : 'AM';
        hours = hours % 12;
        hours = hours ? hours : 12; // the hour '0' should be '12'
        minutes = minutes < 10 ? '0' + minutes : minutes;
        var strTime = hours + ':' + minutes + ampm;
        return strTime;
    };


    utils.convertTimeTo24Hour = function (date) {
        var elem = date.split(':');
        var stHour = elem[0];
        var stAmPm = elem[1].substr(elem[1].length - 2, 2);
        var stMin = elem[1].substr(0, elem[1].length - 2);

        var newhr = 0;
        var ampm = '';
        var newtime = '';
        //alert("hour:"+stHour+"\nmin:"+stMin+"\nampm:"+stAmPm); //see current values

        if (stAmPm === 'PM') {
            if (stHour != 12) {
                stHour = stHour * 1 + 12;
            }

        } else if (stAmPm === 'AM' && stHour == '12') {
            stHour = stHour - 12;
        } else {
            stHour = stHour;
        }

        return {hours: stHour, minutes: stMin}
    };




    return utils;
}]);








