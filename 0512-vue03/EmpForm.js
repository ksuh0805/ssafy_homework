export default {
    template: `
    <div class="container">
        <div class="custom-form-group">
            <label for="name">이름</label>
            <input
            type="text"
            id="name"
            placeholder="이름을 입력하세요"
            style="width: 300px"
            v-model="name"
            />
        </div>
        <div class="custom-form-group">
            <label for="email">이메일</label>
            <input
            type="email"
            id="email"
            placeholder="이메일을 입력하세요"
            style="width: 250px"
            v-model="email"
            />
        </div>
        <div class="custom-form-group">
            <label for="hireDate">고용일</label>
            <input type="date" id="hireDate" placeholder="고용일을 입력하세요" v-model="hireDate"/>
        </div>
        <div class="custom-form-group">
            <label for="manager">관리자</label>
            <select id="manager" placeholder="관리자를 입력하세요" v-model="manager">
            <option disabled value="">관리자 선택</option>
            <option v-for="man in managerOptions">{{man}}</option>
            <option>없음</option>
            </select>
        </div>
        <div class="custom-form-group">
            <label for="position">직책</label>
            <select id="position" v-model="position">
            <option disabled value="">직책을 선택하세요</option>
            <option v-for="pos in positions">{{pos}}</option>
            </select>
        </div>
        <div class="custom-form-group">
            <label for="deptName">부서</label>
            <select type="text" id="deptName" v-model="deptName">
            <option disabled value="">부서를 선택하세요</option>
            <option v-for="dept in deptNames">{{dept}}</option>
            </select>
        </div>
        <div class="custom-form-group">
            <label for="salary">월급</label>
            <input type="text" id="salary" placeholder="월급을 입력하세요" v-model="salary"/>
        </div>
        <div class="custom-form-group">
            <label for="commission">커미션</label>
            <input
            type="text"
            id="commission"
            placeholder="커미션 금액을 입력하세요"
            style="width: 250px"
            v-model="commission"
            />
        </div>
        <div style="text-align: center">
            <button class="button" @click="addEmployee">사원추가</button>
        </div>
    </div>
    `,
    data() {
        return {
            positions: [
                '사장',
                '기획부장',
                '영업부장',
                '총무부장',
                '인사부장',
                '과장',
                '영업대표이사',
                '사원',
            ],
            deptNames: ['기획', '영업', '총무', '인사', '기타'],
            id: '',
            name: '', //이름
            email: '', // 이메일
            hireDate: '', //고용일
            manager: '', //관리자
            position: '', //직책
            deptName: '', //부서
            salary: 0, //월급
            commission: 0, //커미션
            managerOptions: [],
        };
    },
    methods: {
        addEmployee() {
            let empsData = localStorage.getItem('empsData');
            let newsData = {
                no: 0,
                items: [],
            }
            if (empsData) {
                newsData = JSON.parse(empsData);
            }
            newsData.items.push({
                id: ++newsData.no,
                name: this.name,
                email: this.email,
                hireData: this.hireData,
                manager: this.manager,
                position: this.position,
                deptName: this.deptName,
                salary: this.salary,
                commission: this.commission,
            });

            localStorage.setItem('empsData', JSON.stringify(newsData));
            location.href = 'hrm_list.html';
        }
    },
    created() {
        let empsData = localStorage.getItem('empsData');
        if (empsData) {
            empsData = JSON.parse(empsData);
            let items = empsData.items;
            items.forEach((emp) => {
                this.managerOptions.push(emp.name);
            });
        }
    },
};