void reverseString(char* s, int sSize){
    int first, last;
    char tmp;
    for(first=0, last=sSize-1; first<last; first++, last--) {
        tmp = s[first];
        s[first] = s[last];
        s[last] = tmp;
    }
}
