class Solution {
public:
    int numberOfWays(string corridor) {
        int mod = 1e9 + 7;
        vector<int> pos;
        for (int i = 0; i < corridor.size(); i++) {
            if (corridor[i] == 'S') {
                pos.push_back(i);
            }
        }
        
        if (pos.size() % 2 || pos.size() == 0)
            return 0;
        long long res = 1;
        int prev = pos[1];
        int numTree;
        for (int i = 2; i < pos.size(); i++)
            if (i%2==0) {
                numTree = pos[i] - prev;
                res = (res * numTree) % mod;
                prev = pos[i + 1];
            }
        return int(res);
    }
};
