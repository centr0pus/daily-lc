class Solution(object):
    def countValidWords(self, sentence):
        sentences = sentence.split()
        cnt = 0
        for i, word in enumerate(sentences):
            valid = True
            sub_cnt = 0  
            for j, letter in enumerate(word):
                if letter.isdigit():
                    valid = False 
                    break
                if letter in ("!",".",",") and j != len(word)-1:
                    valid = False 
                    break
                if (letter == "-" and (j == len(word)-1 or j == 0)) or (letter == "-" and (not word[j-1].isalpha() or not word[j+1].isalpha())):
                    valid = False 
                    break
                if letter == "-":
                    sub_cnt +=1
                    if sub_cnt >1:
                        valid = False 
                        break
            if valid:
                cnt +=1
        return cnt
        
