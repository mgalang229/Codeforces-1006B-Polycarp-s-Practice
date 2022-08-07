#include <bits/stdc++.h>
using namespace std;

//int dx[8] = {1, 0, -1, 0, 1, 1, -1, -1};
//int dy[8] = {0, 1, 0, -1, 1, -1, 1, -1};

//int dx[4] = {1, 0, -1, 0};
//int dy[4] = {0, 1, 0, -1};

//int dx[4] = {-1, -1, 1, 1};
//int dy[4] = {-1, 1, -1, 1};

void test_cases() {
	int n, k;
	cin >> n >> k;
	vector<pair<int, int>> res(n);
	vector<int> a(n);
	for (int i = 0; i < n; i++) {
		cin >> res[i].first;
		a[i] = res[i].first;
		res[i].second = i + 1;
	}
	sort(res.rbegin(), res.rend());
	sort(res.begin(), res.begin() + k, [&](pair<int, int> a, pair<int, int> b) {
		return a.second < b.second;
	});
	int last = 0;
	int sum = 0;
	for (int i = 0; i < k - 1; i++) {
		sum += *max_element(a.begin() + last, a.begin() + res[i].second);
		last = res[i].second;
	}
	sum += *max_element(a.begin() + last, a.end());
	cout << sum << "\n";
	last = 0;
	for (int i = 0; i < k - 1; i++) {
		cout << res[i].second - last << " ";
		last = res[i].second;
	}
	cout << n - last << "\n";
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	int T = 1;
	//cin >> T;
	for (int tc = 1; tc <= T; tc++) {
		test_cases();
	}
}
