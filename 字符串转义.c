void escapeSpace(char *str) {
    if(!str) return;
    int len = strlen(str);
    int newLen = len;
    int i = 0;
    for(i=0; i<len; i++){
        if(str[i]==' ') newLen+=2;
    }
    str[newLen]='\0';
    while(len>0){
        if(str[--len] != ' ') {
            str[--newLen] = str[len];
        } else {
            str[--newLen] = '0';
            str[--newLen] = '2';
            str[--newLen] = '%';
        }
    }
}
