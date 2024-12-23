class Solution {
public:
    int parent[10005];
    void make_set(int v) {
        parent[v] = v; 
    }

    int find_set(int v) {
        if (v == parent[v]) return v; 
        return find_set(parent[v]); 
    }

    void union_sets(int a, int b) {
        a = find_set(a); 
        b = find_set(b); 
        if (a != b) parent[b] = a; 
    }

    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        vector<bool> res;
        for (int i=0; i<=n; i++)
            make_set(i);
            
        for (int z=threshold+1; z <= n; z++) {
            for (int mul = 2; mul <= n / z; mul++)
                union_sets(z, z * mul);
        }
        for (int i=0; i<queries.size(); i++) {
            if (find_set(queries[i][0]) ==  find_set(queries[i][1])) {
                res.push_back(true);
                union_sets(queries[i][0], queries[i][1]);
            } else {
                res.push_back(false);
            }
        }
        return res;
    }
};
