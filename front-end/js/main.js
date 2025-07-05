function valid(message, regex, value){

    if(regex.test(value)){
        return "";
    } else {
        return "\n" + message;
    }

}
