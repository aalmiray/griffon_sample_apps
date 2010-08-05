package devoxx

class Constants {
    static final Map TYPES = [
        catalogs: [
            description: 'Catalogs',
            icon: [category: 'apps', name: 'kcmdf']
        ],
        speakers: [
            description: 'Speakers',
            icon: [category: 'apps', name: 'kdmconfig']
        ],
        presentations: [
            description: 'Presentations',
            icon: [category: 'apps', name: 'tutorials']
        ],
        schedule: [
            description: 'Schedule',
            icon: [category: 'apps', name: 'date']
        ]
    ]

    static final Map EXPERIENCE = [
        novice: [
            icon: [category: 'actions', name: 'oor_minimum']
        ],
        senior: [
            icon: [category: 'actions', name: 'marginal']
        ],
        expert: [
            icon: [category: 'actions', name: 'excellent']
        ],
    ]
}
